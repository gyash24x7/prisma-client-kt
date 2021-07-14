package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateListRelationFilter(
  public val every: UpdateWhereInput? = null,
  public val some: UpdateWhereInput? = null,
  public val none: UpdateWhereInput? = null
)
