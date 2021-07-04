package dev.yashgupta.prisma.generated.inputs.user

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.UserRole
import dev.yashgupta.prisma.generated.inputs.operations.BoolFieldUpdateOperationsInput
import dev.yashgupta.prisma.generated.inputs.operations.StringFieldUpdateOperationsInput

data class UserUpdateInput(
	val Id: StringFieldUpdateOperationsInput?,
	val Name: StringFieldUpdateOperationsInput?,
	val Email: StringFieldUpdateOperationsInput?,
	val RollNumber: StringFieldUpdateOperationsInput?,
	val Department: Department?,
	val Role: UserRole?,
	val Password: StringFieldUpdateOperationsInput?,
	val Salt: StringFieldUpdateOperationsInput?,
	val ProfilePic: StringFieldUpdateOperationsInput?,
	val CoverPic: StringFieldUpdateOperationsInput?,
	val Mobile: StringFieldUpdateOperationsInput?,
	val Upi: StringFieldUpdateOperationsInput?,
	val FinManagerForDept: Department?,
	val Enabled: BoolFieldUpdateOperationsInput?,
	val Verified: BoolFieldUpdateOperationsInput?
)
