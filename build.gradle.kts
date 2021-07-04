val ktorVersion: String by project
val kotlinPoetVersion: String by project

plugins {
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.serialization") version "1.5.20"
	id("com.expediagroup.graphql") version "4.1.1"
}

group = "dev.yashgupta"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation(kotlin("reflect"))
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("io.ktor:ktor-client-core:$ktorVersion")
	implementation("io.ktor:ktor-client-cio:$ktorVersion")
	implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
	implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")
}