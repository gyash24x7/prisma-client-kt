package io.prisma.codegen

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

enum class Os {
	Windows, Darwin, Linux
}

class PrismaPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extensions.create("prisma", PrismaExtension::class.java)
		val generatePrismaClientTask = project.tasks.create("generatePrismaClient", GeneratePrismaClientTask::class.java)
		val downloadBinariesTask = project.tasks.create("downloadBinaries", DownloadBinariesTask::class.java)
		val copySchemaTask = project.tasks.create("copySchema", CopySchemaTask::class.java)

		generatePrismaClientTask.group = "prisma"
		downloadBinariesTask.group = "prisma"
		copySchemaTask.group = "prisma"

//		downloadBinariesTask.dependsOn(copySchemaTask)
		generatePrismaClientTask.dependsOn(copySchemaTask)
	}
}

open class PrismaExtension {
	var schemaPath: String = ""
}

open class GeneratePrismaClientTask : DefaultTask() {

	private val os: Os?
		get() {
			val osName = System.getProperty("os.name").toLowerCase()
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
	private val dmlPath = project.layout.projectDirectory.dir(".prisma").file("schema.prisma").toString()
	private val queryEngineBinaryPath = project.layout.projectDirectory.dir(".prisma").file(queryEngineBinaryName)

	@TaskAction
	fun executeTask() {
		val runtime = Runtime.getRuntime()
		val process = runtime.exec("cmd /c $queryEngineBinaryPath --datamodel-path=$dmlPath cli dmmf")
		val reader = BufferedReader(InputStreamReader(process.inputStream))
		val dmmfString = reader.readText()
		val generatedFolder = project.layout.buildDirectory.dir("generated").get().toString()
		val config = CodegenConfig(dmmfString, outputDir = generatedFolder)
		val exitVal = process.waitFor()
		if (exitVal == 0) {
			Codegen(config).generate()
			println("Success!")
		} else {
			println(dmmfString)
			println("Error!")
		}
	}
}

open class DownloadBinariesTask() : DefaultTask() {
	@TaskAction
	fun executeTask() {
		println("Fetch Platform, Based on Platform fetch binaries from S3, Store binaries in .prisma folder")
	}
}

open class CopySchemaTask() : DefaultTask() {
	@TaskAction
	fun executeTask() {
		val prismaExtension = project.extensions.getByName("prisma") as PrismaExtension
		val schemaFile = project.layout.projectDirectory.file(prismaExtension.schemaPath).asFile
		val destinationFile = project.layout.projectDirectory.dir(".prisma").file("schema.prisma").asFile
		schemaFile.copyTo(destinationFile, overwrite = true)
	}
}