package dev.yashgupta.prisma.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName
import kotlinx.serialization.json.Json

val format = Json {
	prettyPrint = true
	isLenient = true
	ignoreUnknownKeys = true
	coerceInputValues = true
	encodeDefaults = false
	allowStructuredMapKeys = true
	allowSpecialFloatingPointValues = true
}


fun Codegen.getType(location: String, type: String): TypeName = when (location) {
	"scalar" -> when (type) {
		"String" -> ClassName("kotlin", "String")
		"Boolean" -> ClassName("kotlin", "Boolean")
		"Float" -> ClassName("kotlin", "Float")
		"Int" -> ClassName("kotlin", "Int")
		"BigInt" -> ClassName("kotlin", "Long")
		"Decimal" -> ClassName("kotlin", "Double")
		"DateTime" -> ClassName("kotlinx.datetime", "Instant")
		else -> throw AssertionError("Unknown field type: $type")
	}
	"inputObjectTypes" -> ClassName(config.packageNameInputs, type)
	"enumTypes" -> ClassName(config.packageNameEnums, type)
	"outputObjectTypes" -> ClassName(config.packageNameOutputs, type)
	else -> throw AssertionError("Unknown field type: $type")
}