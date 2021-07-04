package dev.yashgupta.prisma.generated.inputs.filters.bool

import dev.yashgupta.prisma.generated.inputs.filters.number.NestedIntFilter

data class BoolWithAggregatesFilter(
	val Equals: Boolean?,
	val Not: NestedBoolWithAggregatesFilter?,
	val _Count: NestedIntFilter?,
	val _Min: NestedBoolFilter?,
	val _Max: NestedBoolFilter?
)
