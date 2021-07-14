package dev.yashgupta.prisma.generated.outputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class Update(
  public val id: String,
  public val brief: String,
  public val subject: String,
  public val details: String,
  public val createdOn: Instant,
  public val createdBy: User,
  public val createdById: String,
  public val byDept: Department
)
