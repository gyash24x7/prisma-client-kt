package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUncheckedUpdateInput(
  public val id: String? = null,
  public val brief: String? = null,
  public val subject: String? = null,
  public val details: String? = null,
  public val createdOn: Instant? = null,
  public val createdById: String? = null,
  public val byDept: Department? = null
)
