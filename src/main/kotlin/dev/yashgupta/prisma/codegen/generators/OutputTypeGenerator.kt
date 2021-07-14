package dev.yashgupta.prisma.codegen.generators

import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.getKtpType

fun Codegen.generateOutputTypes() = dmmf.getOutputs().map { outputType ->
	val fields = outputType.fields.map { schemaField ->
		val type = getKtpType(schemaField.outputType.location, schemaField.outputType.type)
		Field(name = schemaField.name, type = type, nullable = schemaField.isNullable)
	}
	generateType(outputType.name, fields, config.packageNameOutputs)
}
