package dev.yashgupta.prisma.generated.inputs.filters.string

data class NestedStringFilter(
	val Equals: String?,
	val In: List<String>?,
	val NotIn: List<String>?,
	val Lt: String?,
	val Lte: String?,
	val Gt: String?,
	val Gte: String?,
	val Contains: String?,
	val StartsWith: String?,
	val EndsWith: String?,
	val Not: NestedStringFilter?
)
