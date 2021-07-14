package dev.yashgupta.prisma.codegen

import java.util.*


class ProjectionSerializer(private val inputValueSerializer: InputValueSerializer) {

	fun serialize(projection: BaseProjectionNode, isFragment: Boolean = false): String {
		if (projection.fields.isEmpty() && projection.fragments.isEmpty()) {
			return ""
		}

		val prefix = if (isFragment) {
			val schemaType = projection.schemaType ?: (
					projection::class.java.name
						.substringAfterLast(".")
						.substringAfterLast("_")
						.substringBefore("Projection")
					)
			"... on $schemaType { "
		} else {
			"{ "
		}

		val joiner = StringJoiner(" ", prefix, " }")
		projection.fields.forEach { (key, value) ->
			val field = if (projection.inputArguments[key] != null) {
				val inputArgsJoiner = StringJoiner(", ", "(", ")")
				projection.inputArguments[key]?.forEach {
					inputArgsJoiner.add("${it.name}: ${inputValueSerializer.serialize(it.value)}")
				}

				key + inputArgsJoiner.toString()
			} else {
				key
			}

			joiner.add(field)
			value?.let {
				if (it is BaseProjectionNode) {
					joiner.add(" ").add(serialize(it))
				} else {
					joiner.add(" ").add(it.toString())
				}
			}
		}

		projection.fragments.forEach { joiner.add(serialize(it, true)) }

		return joiner.toString()
	}
}
