package dev.yashgupta.prisma.codegen

abstract class GraphQLOperation(val operation: String, val name: String?) {
	val input: MutableMap<String, Any?> = LinkedHashMap()
	var fieldSet: MutableSet<String> = mutableSetOf()

	constructor(operation: String) : this(operation, null)
	constructor() : this("query")

	open fun getOperationType(): String? {
		return operation
	}

	abstract fun getOperationName(): String
}