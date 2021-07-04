package dev.yashgupta.prisma.generated.inputs.user

import dev.yashgupta.prisma.generated.enums.SortOrder

data class UserOrderByInput(
	val Id: SortOrder?,
	val Name: SortOrder?,
	val Email: SortOrder?,
	val RollNumber: SortOrder?,
	val Department: SortOrder?,
	val Role: SortOrder?,
	val Password: SortOrder?,
	val Salt: SortOrder?,
	val ProfilePic: SortOrder?,
	val CoverPic: SortOrder?,
	val Mobile: SortOrder?,
	val Upi: SortOrder?,
	val FinManagerForDept: SortOrder?,
	val Enabled: SortOrder?,
	val Verified: SortOrder?
)
