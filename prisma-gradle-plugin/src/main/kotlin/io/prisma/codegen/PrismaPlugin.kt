package io.prisma.codegen

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

class PrismaPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extensions.create("prisma", PrismaExtension::class.java)
		val task = project.tasks.create("generatePrismaClient", GeneratePrismaClientTask::class.java)
		task.group = "prisma"
	}
}

open class PrismaExtension {
	var schemaPath: String = ""
}

open class GeneratePrismaClientTask : DefaultTask() {
	@TaskAction
	fun executeTask() {
		val prismaExtension = project.extensions.getByName("prisma") as PrismaExtension
		val schemaFile = project.layout.projectDirectory.file(prismaExtension.schemaPath).toString()
		val process = Runtime.getRuntime().exec("cmd /c query-engine-windows.exe --datamodel-path=$schemaFile cli dmmf")
		val reader = BufferedReader(InputStreamReader(process.inputStream))
		val dmmfString = reader.readText()
		val generatedFolder = project.layout.buildDirectory.dir("generated").get().toString()
		val config = CodegenConfig(dmmfString, outputDir = generatedFolder)
		val exitVal = process.waitFor()
		if (exitVal == 0) {
			Codegen(config).generate()
			println("Success!")
		} else {
			println("Error!")
		}
	}
}