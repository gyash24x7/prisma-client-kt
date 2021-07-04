package dev.yashgupta.prisma.utils

// String extensions
fun String.camelCaseToLowerSnakeCase(): String {
	return this.map { if (it.isUpperCase()) "_${it.lowercase()}" else it }.joinToString(separator = "")
		.replaceFirstChar { if (it == '_') ' ' else it }.trim()
}

fun String.snakeCaseToCamelCase(): String {
	var camelCaseString = ""
	var prevChar: Char? = null
	for (c in this) {
		camelCaseString += if (prevChar == '_') c.uppercase() else c.lowercase()
		prevChar = c
	}
	return camelCaseString.split("_").joinToString("")
}

fun String.snakeCaseToPascalCase(): String {
	return this.snakeCaseToCamelCase().replaceFirstChar { it.uppercase() }
}