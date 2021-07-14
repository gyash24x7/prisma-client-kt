package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.UserRole
import kotlinx.serialization.Serializable

@Serializable
public data class NestedEnumUserRoleFilter(
  public val equals: UserRole? = null,
  public val `in`: UserRole? = null,
  public val notIn: UserRole? = null,
  public val not: UserRole? = null
)
