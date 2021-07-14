package dev.yashgupta.prisma.codegen.generators

import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.getKtpType

fun Codegen.generateInputTypes() = dmmf.getInputs().map { inputType ->
	val fields = inputType.fields.map { field ->
		val type = getKtpType(field.inputType!!.location, field.inputType!!.type)
		Field(name = field.name, nullable = !field.isRequired, type = type)
	}

	generateType(inputType.name, fields, config.packageNameInputs)
}
