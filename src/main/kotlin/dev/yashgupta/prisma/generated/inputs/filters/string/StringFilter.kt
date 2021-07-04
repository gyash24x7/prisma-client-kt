package dev.yashgupta.prisma.generated.inputs.filters.string

import dev.yashgupta.prisma.generated.enums.QueryMode

data class StringFilter(
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
	val Not: StringFilter?
)
