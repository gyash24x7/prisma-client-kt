package dev.yashgupta.prisma.codegen

import dev.yashgupta.prisma.DmmfDoc
import dev.yashgupta.prisma.codegen.generators.*
import kotlinx.serialization.decodeFromString

class Codegen(val config: CodegenConfig) {

	val dmmf: DmmfDoc = format.decodeFromString(config.dmmf)

	fun generate() {
		val enumFiles = generateEnums()
		val outputTypeFiles = generateOutputTypes()
		val inputTypeFiles = generateInputTypes()
		val queryFiles = generateQueries()
		val mutationFiles = generateMutations()

		val allFiles = enumFiles + outputTypeFiles + inputTypeFiles + queryFiles + mutationFiles
		allFiles.forEach { it.writeTo(config.outputDir) }
	}

}