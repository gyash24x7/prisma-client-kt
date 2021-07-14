package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskListRelationFilter(
  public val every: TaskWhereInput? = null,
  public val some: TaskWhereInput? = null,
  public val none: TaskWhereInput? = null
)
