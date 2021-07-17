val ktorVersion: String by project
val kotlinPoetVersion: String by project
val jacksonVersion: String by project

plugins {
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.serialization") version "1.5.20"
}

group = "dev.yashgupta"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

sourceSets {
	main {
		java.srcDir("build/generated")
	}
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation(kotlin("reflect"))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
	implementation("ch.qos.logback:logback-classic:1.2.3")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("io.ktor:ktor-client-core:$ktorVersion")
	implementation("io.ktor:ktor-client-cio:$ktorVersion")
	implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
	implementation("io.ktor:ktor-client-serialization:$ktorVersion")
	implementation("com.squareup:kotlinpoet:$kotlinPoetVersion")
	implementation("net.pearx.kasechange:kasechange:1.3.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
	}
}