package dev.yashgupta.prisma.generated.outputs.user

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.UserRole

data class UserMaxAggregateOutputType(
	val Id: String?,
	val Email: String?,
	val RollNumber: String?,
	val Department: Department?,
	val Role: UserRole?,
	val Password: String?,
	val Salt: String?,
	val ProfilePic: String?,
	val CoverPic: String?,
	val Mobile: String?,
	val Upi: String?,
	val FinManagerForDept: Department?,
	val Enabled: Boolean?,
	val Verified: Boolean?
)