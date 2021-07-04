package dev.yashgupta.prisma.generated.inputs.filters.enums

import dev.yashgupta.prisma.generated.enums.UserRole

data class NestedEnumUserRoleFilter(
	val Equals: UserRole?,
	val In: List<UserRole>?,
	val NotIn: List<UserRole>?,
	val Not: UserRole?
)