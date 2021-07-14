package dev.yashgupta.prisma.codegen

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import kotlin.reflect.full.isSubclassOf

class InputValueSerializer {
	companion object {
		val toStringClasses = setOf(
			String::class,
			LocalDateTime::class,
			LocalDate::class,
			TimeZone::class,
			Instant::class
		)
	}

	fun serialize(input: Any?): String {
		if (input == null) return "null"

		val kType = input::class

		if (input.canBeSerializedToString()) return input.toString()

		if (toStringClasses.contains(kType)) {
			return """"${input.toString().replace("\\", "\\\\").replace("\"", "\\\"")}""""
		}

		if (input is List<*>) {
			return """[${input.filterNotNull().joinToString(", ") { listItem -> serialize(listItem) }}]"""
		}

		if (input is Map<*, *>) return input.map { entry ->

			if (entry.value != null) {
				"""${entry.key}: ${serialize(entry.value)}"""
			} else {
				"""${entry.key}: null"""
			}

		}.joinToString(separator = ", ", prefix = "{ ", postfix = " }")


		val fields = mutableListOf<Field>()
		var targetClass: Class<*>? = kType.java

		while (targetClass != null && targetClass != Object::class) {
			targetClass.declaredFields.forEach {
				if (!it.isSynthetic) {
					if (it.canBeMadeAccessible()) it.isAccessible = true
					fields.add(it)
				}
			}
			targetClass = targetClass.superclass
		}

		return fields.filter { !it.type::class.isCompanion }.mapNotNull {
			val nestedValue = it.get(input)
			if (nestedValue != null && nestedValue::class.java == input::class.java) {
				"""${it.name}:$nestedValue"""
			} else if (nestedValue != null && !nestedValue::class.isCompanion) {
				"""${it.name}:${serialize(nestedValue)}"""
			} else {
				null
			}
		}.joinToString(separator = ", ", prefix = "{ ", postfix = " }")
	}
}


fun Field.canBeMadeAccessible() = (!Modifier.isPublic(this.modifiers) ||
		!Modifier.isPublic(this.declaringClass.modifiers) ||
		Modifier.isFinal(this.modifiers)) &&
		!this.isAccessible

fun Any.canBeSerializedToString() = this is Boolean ||
		this is Int ||
		this is Long ||
		this is Float ||
		this is Double ||
		this is Byte ||
		this is Short ||
		this::class.isSubclassOf(Enum::class)
