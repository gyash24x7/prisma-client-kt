package dev.yashgupta.prisma.generated.inputs.filters.enums

import dev.yashgupta.prisma.generated.enums.UserRole

data class EnumUserRoleFilter(
	val Equals: UserRole?,
	val In: List<UserRole>?,
	val NotIn: List<UserRole>?,
	val Not: UserRole?
)