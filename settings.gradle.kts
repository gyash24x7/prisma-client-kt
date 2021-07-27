rootProject.name = "prisma-client-kt"
include("prisma-gradle-plugin")
include("prisma-client")
include("prisma-demo-app")

pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenLocal()
	}
}