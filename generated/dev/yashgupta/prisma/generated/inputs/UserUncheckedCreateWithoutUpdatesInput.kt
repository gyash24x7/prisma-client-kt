package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.UserRole
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class UserUncheckedCreateWithoutUpdatesInput(
  public val id: String? = null,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole? = null,
  public val password: String,
  public val salt: String,
  public val profilePic: String? = null,
  public val coverPic: String? = null,
  public val mobile: String,
  public val upi: String? = null,
  public val finManagerForDept: Department? = null,
  public val enabled: Boolean? = null,
  public val verified: Boolean? = null,
  public val tasksCreated: TaskUncheckedCreateNestedManyWithoutCreatedByInput? = null
)
