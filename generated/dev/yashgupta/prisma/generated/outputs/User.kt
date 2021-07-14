package dev.yashgupta.prisma.generated.outputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.UserRole
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class User(
  public val id: String,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole,
  public val password: String,
  public val salt: String,
  public val profilePic: String,
  public val coverPic: String,
  public val mobile: String,
  public val upi: String,
  public val finManagerForDept: Department? = null,
  public val enabled: Boolean,
  public val verified: Boolean,
  public val updates: Update? = null,
  public val tasksAssigned: Task? = null,
  public val tasksCreated: Task? = null
)
