package dev.yashgupta.prisma.generated.inputs.filters.enums

import dev.yashgupta.prisma.generated.enums.Department

data class EnumDepartmentFilter(
	val Equals: Department?,
	val In: List<Department>?,
	val NotIn: List<Department>?,
	val Not: Department?
)