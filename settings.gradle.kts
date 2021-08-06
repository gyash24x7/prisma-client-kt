rootProject.name = "prisma-client-kt"
include("prisma-gradle-plugin")
include("prisma-client")

pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenLocal()
	}
}