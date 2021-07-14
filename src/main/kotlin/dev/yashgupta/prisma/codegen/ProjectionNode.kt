package dev.yashgupta.prisma.codegen

import java.util.*

abstract class BaseProjectionNode(val schemaType: String? = null) {

	val fields: MutableMap<String, Any?> = LinkedHashMap()
	val fragments: MutableList<BaseSubProjectionNode<*, *>> = LinkedList()
	val inputArguments: MutableMap<String, MutableList<InputArgument>> = LinkedHashMap()

	data class InputArgument(val name: String, val value: Any?)
}

abstract class BaseSubProjectionNode<T, R>(val parent: T, val root: R, schemaType: String? = null) :
	BaseProjectionNode(schemaType) {

	fun parent() = parent

	fun root() = root
}
