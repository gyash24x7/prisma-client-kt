package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.UserRole
import kotlinx.serialization.Serializable

@Serializable
public data class NestedEnumUserRoleWithAggregatesFilter(
  public val equals: UserRole? = null,
  public val `in`: UserRole? = null,
  public val notIn: UserRole? = null,
  public val not: UserRole? = null,
  public val _count: NestedIntFilter? = null,
  public val _min: NestedEnumUserRoleFilter? = null,
  public val _max: NestedEnumUserRoleFilter? = null
)
