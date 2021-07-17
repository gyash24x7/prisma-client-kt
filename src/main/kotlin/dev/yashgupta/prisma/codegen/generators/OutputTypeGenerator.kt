package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.LIST
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.getType

fun Codegen.generateOutputTypes() = dmmf.outputs.map { outputType ->
	val fields = outputType.fields.map { schemaField ->
		var type = getType(schemaField.outputType.location, schemaField.outputType.type)
		if (schemaField.outputType.isList) type = LIST.parameterizedBy(type)
		type = type.copy(nullable = schemaField.isNullable)
		
		Field(name = schemaField.name, type = type, nullable = schemaField.isNullable)
	}
	generateType(outputType.name, fields, config.packageNameOutputs)
}
