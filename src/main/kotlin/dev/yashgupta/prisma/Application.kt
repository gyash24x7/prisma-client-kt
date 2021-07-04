package dev.yashgupta.prisma

import dev.yashgupta.prisma.utils.format
import kotlinx.serialization.decodeFromString

fun main() {
	val jsonString = object {}::class.java.classLoader.getResource("schema.json")?.readText() ?: ""
	val document = format.decodeFromString<Document>(jsonString)
	val generator = Generator(document)
	generator.generateEnums()
	generator.generateFilters()
}