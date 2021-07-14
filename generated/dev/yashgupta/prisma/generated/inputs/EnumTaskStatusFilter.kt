package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.TaskStatus
import kotlinx.serialization.Serializable

@Serializable
public data class EnumTaskStatusFilter(
  public val equals: TaskStatus? = null,
  public val `in`: TaskStatus? = null,
  public val notIn: TaskStatus? = null,
  public val not: TaskStatus? = null
)
