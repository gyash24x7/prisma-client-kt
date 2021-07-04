package dev.yashgupta.prisma.generated.inputs.filters.enums

import dev.yashgupta.prisma.generated.enums.UserRole
import dev.yashgupta.prisma.generated.inputs.filters.number.NestedIntNullableFilter

data class EnumUserRoleWithAggregatesFilter(
	val Equals: UserRole?,
	val In: List<UserRole>?,
	val NotIn: List<UserRole>?,
	val Not: UserRole?,
	val _Count: NestedIntNullableFilter?,
	val _Min: NestedEnumUserRoleFilter?,
	val _Max: NestedEnumUserRoleFilter?
)