package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserListRelationFilter(
  public val every: UserWhereInput? = null,
  public val some: UserWhereInput? = null,
  public val none: UserWhereInput? = null
)
