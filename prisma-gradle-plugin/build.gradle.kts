plugins {
	kotlin("jvm")
	kotlin("plugin.serialization")
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation(kotlin("reflect"))
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("com.squareup:kotlinpoet:1.9.0")
	implementation("net.pearx.kasechange:kasechange:1.3.0")
	implementation(project(":prisma-client"))
}
