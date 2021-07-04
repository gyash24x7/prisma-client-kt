package dev.yashgupta.prisma.generated.inputs.user

import dev.yashgupta.prisma.generated.inputs.filters.bool.BoolFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumDepartmentFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumDepartmentNullableFilter
import dev.yashgupta.prisma.generated.inputs.filters.enums.EnumUserRoleFilter
import dev.yashgupta.prisma.generated.inputs.filters.string.StringFilter

data class UserWhereInput(
	val AND: UserWhereInput?,
	val OR: List<UserWhereInput>?,
	val NOT: UserWhereInput?,
	val Id: StringFilter?,
	val Name: StringFilter?,
	val Email: StringFilter?,
	val RollNumber: StringFilter?,
	val Department: EnumDepartmentFilter?,
	val Role: EnumUserRoleFilter?,
	val Password: StringFilter?,
	val Salt: StringFilter?,
	val ProfilePic: StringFilter?,
	val CoverPic: StringFilter?,
	val Mobile: StringFilter?,
	val Upi: StringFilter?,
	val FinManagerForDept: EnumDepartmentNullableFilter?,
	val Enabled: BoolFilter?,
	val Verified: BoolFilter?
)
