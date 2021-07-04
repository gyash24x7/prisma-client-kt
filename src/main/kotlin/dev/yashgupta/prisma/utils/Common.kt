package dev.yashgupta.prisma.utils

import kotlinx.serialization.json.Json
import kotlin.reflect.KProperty1

typealias Dictionary<T> = MutableMap<String, T>

@Suppress("UNCHECKED_CAST")
fun readInstanceProperty(instance: Any, propertyName: String): String {
	val property = instance::class.members.first { it.name == propertyName } as KProperty1<Any, *>
	return property.get(instance) as String
}

fun <T : Any> keyBy(collection: List<T>, prop: String): Dictionary<T> {
	val acc: Dictionary<T> = mutableMapOf()
	collection.forEach {
		val key = readInstanceProperty(it, prop)
		acc[key] = it
	}

	return acc
}

fun <T : Any> keyBy2(collection1: List<T>, collection2: List<T>, prop: String): Dictionary<T> {
	val acc: Dictionary<T> = mutableMapOf()

	(collection1 + collection2).forEach {
		val key = readInstanceProperty(it, prop)
		acc[key] = it
	}

	return acc
}

val scalarTypeTable: Map<String, Boolean> = mapOf(
	Pair("String", true),
	Pair("Int", true),
	Pair("Float", true),
	Pair("Boolean", true),
	Pair("Long", true),
	Pair("DateTime", true),
	Pair("ID", true),
	Pair("UUID", true),
	Pair("Json", true),
	Pair("Bytes", true),
	Pair("Decimal", true),
	Pair("BigInt", true),
)

fun isScalar(str: String): Boolean {
	return scalarTypeTable[str] ?: false
}

val format = Json {
	prettyPrint = true
	isLenient = true
	ignoreUnknownKeys = true
	coerceInputValues = true
	encodeDefaults = true
	allowStructuredMapKeys = true
	allowSpecialFloatingPointValues = true
}