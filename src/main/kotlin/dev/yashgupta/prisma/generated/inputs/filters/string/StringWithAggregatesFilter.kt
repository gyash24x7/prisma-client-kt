package dev.yashgupta.prisma.generated.inputs.filters.string

import dev.yashgupta.prisma.generated.enums.QueryMode
import dev.yashgupta.prisma.generated.inputs.filters.number.NestedIntFilter

data class StringWithAggregatesFilter(
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
	val Mode: QueryMode?,
	val Not: NestedStringWithAggregatesFilter?,
	val _Count: NestedIntFilter?,
	val _Min: NestedIntFilter?,
	val _Max: NestedStringFilter?
)
