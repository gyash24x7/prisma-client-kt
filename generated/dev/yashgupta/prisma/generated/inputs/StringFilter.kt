package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.QueryMode
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class StringFilter(
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
  public val mode: QueryMode? = null,
  public val not: String? = null
)
