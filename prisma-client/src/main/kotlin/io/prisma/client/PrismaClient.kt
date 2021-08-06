package io.prisma.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import java.io.IOException
import java.net.ServerSocket
import kotlin.io.path.Path


enum class Os {
	Windows, Darwin, Linux
}

class PrismaClient {

	private var _port = 0
	private lateinit var _process: Process

	private val os: Os?
		get() {
			val osName = System.getProperty("os.name").lowercase()
			return when {
				osName.contains("win") -> Os.Windows
				osName.contains("mac") -> Os.Darwin
				osName.contains("nix") || osName.contains("nux") || osName.contains("aix") -> Os.Linux
				else -> null
			}
		}

	private val queryEngineBinaryName = when (os) {
		Os.Windows -> "query-engine-${os!!.name}.exe"
		else -> "query-engine-${os!!.name}"
	}

	init {
		findFreePort()
		connect()
		Runtime.getRuntime().addShutdownHook(Thread {
			disconnect()
		})
	}

	private val client = HttpClient(CIO) {
		install(Logging) {
			level = LogLevel.BODY
			logger = Logger.DEFAULT
		}
		install(JsonFeature) {
			serializer = KotlinxSerializer(json)
		}
	}

	private fun findFreePort() {
		var socket: ServerSocket? = null
		_port = try {
			socket = ServerSocket(0)
			socket.reuseAddress = true
			socket.localPort
		} catch (e: IOException) {
			throw e
		} finally {
			if (socket != null) {
				try {
					socket.close()
				} catch (e: IOException) {
				}
			}
		}
	}

	private fun connect() {
		val dmlPath = Path(System.getProperty("user.dir"), ".prisma", "schema.prisma")
		val queryEngineBinaryPath = Path(System.getProperty("user.dir"), ".prisma", queryEngineBinaryName)
		_process = ProcessBuilder("$queryEngineBinaryPath", "--datamodel-path", "$dmlPath", "-g", "--port", "$_port")
			.start()
	}

	private fun disconnect() {
		println("Shutting Down Prisma Client...")
		_process.destroyForcibly()
	}

	suspend fun execute(query: Query): JsonElement? {
		val response = client.request<JsonElement> {
			url { port = _port }
			method = HttpMethod.Post
			body = Request(query.serialize())
			headers {
				append(HttpHeaders.ContentType, "application/json")
			}
		}

		return response.jsonObject["data"]?.jsonObject?.get(query.name)
	}
}

@Serializable
data class Request(val query: String) {
	val operationName: String? = null
	val variables: Map<String, String> = emptyMap()
}