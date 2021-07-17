package dev.yashgupta.prisma.codegen.generators

import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.getType

fun Codegen.generateInputTypes() = dmmf.inputs.map { inputType ->
	val fields = inputType.fields.map { field ->
		val type = getType(field.inputType!!.location, field.inputType!!.type)
		Field(name = field.name, nullable = !field.isRequired, type = type)
	}

	generateType(inputType.name, fields, config.packageNameInputs)
}