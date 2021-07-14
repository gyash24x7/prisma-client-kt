package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUncheckedCreateInput(
  public val id: String? = null,
  public val brief: String,
  public val subject: String,
  public val details: String,
  public val createdOn: Instant? = null,
  public val createdById: String,
  public val byDept: Department
)
