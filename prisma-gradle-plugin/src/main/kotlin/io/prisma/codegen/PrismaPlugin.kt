package io.prisma.codegen

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction

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

	@Input
	@Optional
	var schemaPath: String = ""

	@TaskAction
	fun executeTask() {
		val prismaExtension = project.extensions.getByName("prisma") as PrismaExtension
		println("Hello from Prisma Plugin")
		println(prismaExtension.schemaPath)
		val schemaFile = project.layout.projectDirectory.file(prismaExtension.schemaPath).asFile
		println(schemaFile.readText())
	}
}