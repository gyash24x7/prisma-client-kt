package dev.yashgupta.prisma.generated.inputs.filters.string

import dev.yashgupta.prisma.generated.inputs.filters.number.NestedIntFilter

data class NestedStringWithAggregatesFilter(
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
	val Not: NestedStringWithAggregatesFilter?,
	val _Count: NestedIntFilter?,
	val _Min: NestedStringFilter?,
	val _Max: NestedStringFilter?
)
