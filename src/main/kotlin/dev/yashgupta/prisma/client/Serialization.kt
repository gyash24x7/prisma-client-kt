package dev.yashgupta.prisma.client

import kotlinx.serialization.json.*

val json = Json {
	prettyPrint = true
	isLenient = true
	ignoreUnknownKeys = true
	coerceInputValues = true
	encodeDefaults = true
	allowStructuredMapKeys = true
	allowSpecialFloatingPointValues = true
}

fun serializeInput(input: JsonElement, isEntry: Boolean = false): String {
	val prefix = if (isEntry) "( " else "{ "
	val postfix = if (isEntry) " )" else " }"

	return when (input) {
		is JsonArray -> """[${input.joinToString(", ") { serializeInput(it) }}]"""
		is JsonPrimitive -> if (input.isString) input.getIfEnum() ?: input.toString() else input.content
		is JsonObject -> input.entries.filterNot { it.value is JsonNull }
			.joinToString(prefix = prefix, separator = ", ", postfix = postfix) {
				"""${it.key}: ${serializeInput(it.value)}"""
			}
		else -> ""
	}
}

fun serializeSelection(selection: JsonObject): String = selection.mapNotNull {
	when (it.value) {
		is JsonNull -> null
		is JsonArray -> null
		is JsonPrimitive -> if (it.value.jsonPrimitive.boolean) it.key else null
		is JsonObject -> {
			var selectionString = it.key
			val args = buildJsonObject {
				(it.value as JsonObject)
					.filter { arg -> arg.value !is JsonNull && arg.key != "select" }
					.forEach { arg -> put(arg.key, arg.value) }
			}

			val selectionJson = it.value.jsonObject["select"]!!.jsonObject
			if (args.isNotEmpty()) selectionString += " ${serializeInput(args, true)}"
			selectionString += " ${serializeSelection(selectionJson)}"
			selectionString
		}
	}
}.joinToString(separator = ", ", prefix = "{ ", postfix = " }")

fun JsonPrimitive.getIfEnum(): String? {
	if (content.startsWith("__enum__")) return content.substring(content.lastIndexOf("__") + 2)
	return null
}

fun Query.serialize(): String {
	val (type, name, operation, selection) = this
	return buildString {
		append(type)
		append(" { ")
		append(name)
		if (operation.isNotEmpty()) {
			append(serializeInput(operation, true))
		}
		append(serializeSelection(selection))
		append(" }")
	}
}

data class Query(
	val type: String,
	val name: String,
	val input: JsonObject,
	val selection: JsonObject
)