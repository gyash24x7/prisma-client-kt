package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.SortOrder
import kotlinx.serialization.Serializable

@Serializable
public data class UserOrderByInput(
  public val id: SortOrder? = null,
  public val name: SortOrder? = null,
  public val email: SortOrder? = null,
  public val rollNumber: SortOrder? = null,
  public val department: SortOrder? = null,
  public val role: SortOrder? = null,
  public val password: SortOrder? = null,
  public val salt: SortOrder? = null,
  public val profilePic: SortOrder? = null,
  public val coverPic: SortOrder? = null,
  public val mobile: SortOrder? = null,
  public val upi: SortOrder? = null,
  public val finManagerForDept: SortOrder? = null,
  public val enabled: SortOrder? = null,
  public val verified: SortOrder? = null
)
