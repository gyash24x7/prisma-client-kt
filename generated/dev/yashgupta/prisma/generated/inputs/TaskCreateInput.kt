package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import dev.yashgupta.prisma.generated.enums.TaskStatus
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateInput(
  public val id: String? = null,
  public val brief: String,
  public val details: String,
  public val deadline: Instant,
  public val createdOn: Instant? = null,
  public val byDepartment: Department,
  public val forDepartment: Department,
  public val status: TaskStatus? = null,
  public val createdBy: UserCreateNestedOneWithoutTasksCreatedInput,
  public val assignedTo: UserCreateNestedManyWithoutTasksAssignedInput? = null
)
