plugins {
	base
	kotlin("jvm") version "1.5.20" apply false
	kotlin("plugin.serialization") version "1.5.20" apply false
}

allprojects {
	group = "io.prisma"
	version = "1.0-SNAPSHOT"

	repositories {
		mavenLocal()
		mavenCentral()
	}

	tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
		}
	}
}