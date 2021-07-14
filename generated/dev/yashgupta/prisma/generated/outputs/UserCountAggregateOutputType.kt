package dev.yashgupta.prisma.generated.outputs

import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public data class UserCountAggregateOutputType(
  public val id: Int,
  public val name: Int,
  public val email: Int,
  public val rollNumber: Int,
  public val department: Int,
  public val role: Int,
  public val password: Int,
  public val salt: Int,
  public val profilePic: Int,
  public val coverPic: Int,
  public val mobile: Int,
  public val upi: Int,
  public val finManagerForDept: Int,
  public val enabled: Int,
  public val verified: Int,
  public val _all: Int
)
