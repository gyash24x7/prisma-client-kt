package dev.yashgupta.prisma.codegen

import kotlinx.serialization.json.*

fun serializeInput(input: JsonElement?): String = when (input) {
	null -> "null"
	is JsonNull -> "null"
	is JsonArray -> """[${input.filterNot { it is JsonNull }.joinToString(", ") { serializeInput(it) }}]"""
	is JsonPrimitive -> if (input.isString) input.getIfEnum() ?: input.toString() else input.content
	is JsonObject -> input.map { (key, value) -> """$key: ${serializeInput(value)}""" }
		.joinToString(separator = ", ", prefix = "{ ", postfix = " }")
}

fun JsonPrimitive.getIfEnum(): String? {
	if (content.startsWith("__enum__")) return content.substring(content.lastIndexOf("__") + 2)
	return null
}

interface GraphQLOperation {
	val type: String
	val name: String
}

inline fun <reified T : GraphQLOperation> serializeOperation(operation: T) = buildString {
	append(operation.type)
	append(" { ")
	append(operation.name)
	val operationJson = format.encodeToJsonElement(operation)
	if (operationJson is JsonObject && operationJson.isNotEmpty()) {
		append("( ")
		append(operationJson.entries.joinToString(", ") { (key, value) -> "${key}: ${serializeInput(value)}" })
		append(" )")
	}
	append(" }")
}