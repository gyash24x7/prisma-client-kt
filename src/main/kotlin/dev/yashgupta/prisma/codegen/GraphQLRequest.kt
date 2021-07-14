package dev.yashgupta.prisma.codegen

class GraphQLRequest(
	private val operation: GraphQLOperation,
	private val projection: BaseProjectionNode?
) {

	constructor(operation: GraphQLOperation) : this(operation, null)

	private val inputValueSerializer = InputValueSerializer()
	private val projectionSerializer = ProjectionSerializer(inputValueSerializer)

	fun serialize(): String {
		val builder = StringBuilder()
		builder.append(operation.getOperationType())
		if (operation.name != null) {
			builder.append(" ").append(operation.name)
		}
		builder.append(" {").append(operation.getOperationName())
		val input: Map<String, Any?> = operation.input
		if (input.isNotEmpty()) {
			builder.append("(")
			val inputEntryIterator = input.entries.iterator()
			while (inputEntryIterator.hasNext()) {
				val (key, value) = inputEntryIterator.next()
				builder.append(key)
				builder.append(": ")
				builder.append(inputValueSerializer.serialize(value))
				if (inputEntryIterator.hasNext()) {
					builder.append(", ")
				}
			}
			builder.append(")")
		}

		if (projection is BaseSubProjectionNode<*, *>) {
			builder.append(projectionSerializer.serialize(projection.root() as BaseProjectionNode))
		} else if (projection != null) {
			builder.append(projectionSerializer.serialize(projection))
		}

		builder.append(" }")
		return builder.toString()
	}
}
