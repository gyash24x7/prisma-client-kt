package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.UserRole
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class UserUncheckedUpdateWithoutTasksCreatedInput(
  public val id: String? = null,
  public val name: String? = null,
  public val email: String? = null,
  public val rollNumber: String? = null,
  public val department: Department? = null,
  public val role: UserRole? = null,
  public val password: String? = null,
  public val salt: String? = null,
  public val profilePic: String? = null,
  public val coverPic: String? = null,
  public val mobile: String? = null,
  public val upi: String? = null,
  public val finManagerForDept: Department? = null,
  public val enabled: Boolean? = null,
  public val verified: Boolean? = null,
  public val updates: UpdateUncheckedUpdateManyWithoutCreatedByInput? = null
)
