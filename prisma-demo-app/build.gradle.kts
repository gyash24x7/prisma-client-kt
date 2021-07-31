plugins {
	kotlin("jvm")
	id("io.prisma.codegen") version "1.0-SNAPSHOT"
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation("io.prisma:prisma-client:1.0-SNAPSHOT")
	implementation("io.ktor:ktor-client-serialization:1.6.0")
}

sourceSets {
	main {
		java.srcDir("build/generated")
	}
}

prisma {
	schemaPath = "src/main/resources/schema.prisma"
}