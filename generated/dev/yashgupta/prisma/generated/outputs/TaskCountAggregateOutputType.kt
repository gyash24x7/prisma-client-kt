package dev.yashgupta.prisma.generated.outputs

import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public data class TaskCountAggregateOutputType(
  public val id: Int,
  public val brief: Int,
  public val details: Int,
  public val deadline: Int,
  public val createdOn: Int,
  public val byDepartment: Int,
  public val forDepartment: Int,
  public val createdById: Int,
  public val status: Int,
  public val _all: Int
)
