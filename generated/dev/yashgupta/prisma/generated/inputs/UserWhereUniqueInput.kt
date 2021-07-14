package dev.yashgupta.prisma.generated.inputs

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class UserWhereUniqueInput(
  public val id: String? = null,
  public val email: String? = null,
  public val rollNumber: String? = null,
  public val salt: String? = null
)
