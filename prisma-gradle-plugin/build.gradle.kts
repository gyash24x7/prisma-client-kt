plugins {
	kotlin("jvm")
	kotlin("plugin.serialization")
	`java-gradle-plugin`
	`maven-publish`
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("com.squareup:kotlinpoet:1.9.0")
	implementation("net.pearx.kasechange:kasechange:1.3.0")
	implementation("com.lordcodes.turtle:turtle:0.5.0")
	implementation(project(":prisma-client"))
}

gradlePlugin {
	plugins {
		create("prismaPlugin") {
			id = "io.prisma.codegen"
			implementationClass = "io.prisma.codegen.PrismaPlugin"
		}
	}
}