package dev.yashgupta.prisma.generated.inputs

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class NestedDateTimeWithAggregatesFilter(
  public val equals: Instant? = null,
  public val `in`: Instant? = null,
  public val notIn: Instant? = null,
  public val lt: Instant? = null,
  public val lte: Instant? = null,
  public val gt: Instant? = null,
  public val gte: Instant? = null,
  public val not: Instant? = null,
  public val _count: NestedIntFilter? = null,
  public val _min: NestedDateTimeFilter? = null,
  public val _max: NestedDateTimeFilter? = null
)
