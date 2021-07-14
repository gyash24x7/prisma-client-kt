package dev.yashgupta.prisma.generated.inputs

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class NestedStringWithAggregatesFilter(
  public val equals: String? = null,
  public val `in`: String? = null,
  public val notIn: String? = null,
  public val lt: String? = null,
  public val lte: String? = null,
  public val gt: String? = null,
  public val gte: String? = null,
  public val contains: String? = null,
  public val startsWith: String? = null,
  public val endsWith: String? = null,
  public val not: String? = null,
  public val _count: NestedIntFilter? = null,
  public val _min: NestedStringFilter? = null,
  public val _max: NestedStringFilter? = null
)
