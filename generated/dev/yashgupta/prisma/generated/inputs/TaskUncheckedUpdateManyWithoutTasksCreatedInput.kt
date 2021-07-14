package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.TaskStatus
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class TaskUncheckedUpdateManyWithoutTasksCreatedInput(
  public val id: String? = null,
  public val brief: String? = null,
  public val details: String? = null,
  public val deadline: Instant? = null,
  public val createdOn: Instant? = null,
  public val byDepartment: Department? = null,
  public val forDepartment: Department? = null,
  public val status: TaskStatus? = null
)
