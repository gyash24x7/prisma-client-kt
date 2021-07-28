plugins {
	kotlin("jvm")
	kotlin("plugin.serialization")
	`maven-publish`
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("io.ktor:ktor-client-core:1.6.0")
	implementation("io.ktor:ktor-client-cio:1.6.0")
	implementation("io.ktor:ktor-client-logging-jvm:1.6.0")
	implementation("io.ktor:ktor-client-serialization:1.6.0")
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			groupId = "io.prisma"
			artifactId = "prisma-client"

			from(components["java"])
		}
	}
}