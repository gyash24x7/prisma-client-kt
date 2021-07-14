package dev.yashgupta.prisma.generated.inputs

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class DateTimeFilter(
  public val equals: Instant? = null,
  public val `in`: Instant? = null,
  public val notIn: Instant? = null,
  public val lt: Instant? = null,
  public val lte: Instant? = null,
  public val gt: Instant? = null,
  public val gte: Instant? = null,
  public val not: Instant? = null
)
