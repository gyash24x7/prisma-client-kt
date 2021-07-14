package dev.yashgupta.prisma.generated.inputs

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public data class BoolWithAggregatesFilter(
  public val equals: Boolean? = null,
  public val not: Boolean? = null,
  public val _count: NestedIntFilter? = null,
  public val _min: NestedBoolFilter? = null,
  public val _max: NestedBoolFilter? = null
)
