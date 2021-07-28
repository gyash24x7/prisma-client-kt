plugins {
	kotlin("jvm")
	id("io.prisma.codegen") version "1.0-SNAPSHOT"
}

dependencies {
	implementation(kotlin("stdlib"))
}

prisma {
	schemaPath = "src/main/resources/schema.prisma"
}