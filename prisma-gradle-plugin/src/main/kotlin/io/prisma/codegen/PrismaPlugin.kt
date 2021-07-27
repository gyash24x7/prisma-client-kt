package io.prisma.codegen

import org.gradle.api.Plugin
import org.gradle.api.Project

class PrismaPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.task("generatePrismaClient").doLast {
			println("Hello from prisma plugin!")
		}
	}
}