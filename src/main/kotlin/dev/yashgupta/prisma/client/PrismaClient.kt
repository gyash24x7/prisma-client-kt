package dev.yashgupta.prisma.client

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

class PrismaClient {
	val client = HttpClient(CIO) {
		install(Logging) {
			level = LogLevel.BODY
			logger = Logger.DEFAULT
		}
		install(JsonFeature) {
			serializer = KotlinxSerializer(json)
		}
	}

	suspend fun execute(query: Query): JsonElement? {
		val response = client.request<JsonElement> {
			url { port = 4466 }
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