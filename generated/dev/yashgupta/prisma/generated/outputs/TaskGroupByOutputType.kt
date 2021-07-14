package dev.yashgupta.prisma.generated.outputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.TaskStatus
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class TaskGroupByOutputType(
  public val id: String,
  public val brief: String,
  public val details: String,
  public val deadline: Instant,
  public val createdOn: Instant,
  public val byDepartment: Department,
  public val forDepartment: Department,
  public val createdById: String,
  public val status: TaskStatus,
  public val _count: TaskCountAggregateOutputType? = null,
  public val _min: TaskMinAggregateOutputType? = null,
  public val _max: TaskMaxAggregateOutputType? = null
)
