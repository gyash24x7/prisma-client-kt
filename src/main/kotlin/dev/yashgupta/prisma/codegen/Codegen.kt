package dev.yashgupta.prisma.codegen

import dev.yashgupta.prisma.DmmfDoc
import dev.yashgupta.prisma.codegen.generators.generateEnums
import dev.yashgupta.prisma.codegen.generators.generateInputTypes
import dev.yashgupta.prisma.codegen.generators.generateOperations
import dev.yashgupta.prisma.codegen.generators.generateOutputTypes
import kotlinx.serialization.decodeFromString

class Codegen(val config: CodegenConfig) {

	val dmmf: DmmfDoc = format.decodeFromString(config.dmmf)

	fun generate() {
		val enumFiles = generateEnums()
		val outputTypeFiles = generateOutputTypes()
		val inputTypeFiles = generateInputTypes()
		val operationFiles = generateOperations()

		val allFiles = enumFiles + outputTypeFiles + inputTypeFiles + operationFiles
		allFiles.forEach { it.writeTo(config.outputDir) }
	}

}