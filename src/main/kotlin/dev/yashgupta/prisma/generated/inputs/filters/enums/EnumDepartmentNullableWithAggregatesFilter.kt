package dev.yashgupta.prisma.generated.inputs.filters.enums

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.inputs.filters.number.NestedIntNullableFilter

data class EnumDepartmentNullableWithAggregatesFilter(
	val Equals: Department?,
	val In: List<Department>?,
	val NotIn: List<Department>?,
	val Not: Department?,
	val _Count: NestedIntNullableFilter?,
	val _Min: NestedEnumDepartmentNullableFilter?,
	val _Max: NestedEnumDepartmentNullableFilter?
)