package dev.yashgupta.prisma.generated.inputs.user

import dev.yashgupta.prisma.generated.inputs.filters.bool.BoolWithAggregatesFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumDepartmentNullableWithAggregatesFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumDepartmentWithAggregatesFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumUserRoleWithAggregatesFilter
import dev.yashgupta.prisma.generated.inputs.filters.string.StringWithAggregatesFilter

data class UserScalarWhereWithAggregatesInput(
	val AND: UserScalarWhereWithAggregatesInput?,
	val OR: List<UserScalarWhereWithAggregatesInput>?,
	val NOT: UserScalarWhereWithAggregatesInput?,
	val Id: StringWithAggregatesFilter?,
	val Name: StringWithAggregatesFilter?,
	val Email: StringWithAggregatesFilter?,
	val RollNumber: StringWithAggregatesFilter?,
	val Department: EnumDepartmentWithAggregatesFilter?,
	val Role: EnumUserRoleWithAggregatesFilter?,
	val Password: StringWithAggregatesFilter?,
	val Salt: StringWithAggregatesFilter?,
	val ProfilePic: StringWithAggregatesFilter?,
	val CoverPic: StringWithAggregatesFilter?,
	val Mobile: StringWithAggregatesFilter?,
	val Upi: StringWithAggregatesFilter?,
	val FinManagerForDept: EnumDepartmentNullableWithAggregatesFilter?,
	val Enabled: BoolWithAggregatesFilter?,
	val Verified: BoolWithAggregatesFilter?
)
