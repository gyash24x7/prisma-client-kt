package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskScalarWhereWithAggregatesInput(
  public val AND: TaskScalarWhereWithAggregatesInput? = null,
  public val OR: TaskScalarWhereWithAggregatesInput? = null,
  public val NOT: TaskScalarWhereWithAggregatesInput? = null,
  public val id: StringWithAggregatesFilter? = null,
  public val brief: StringWithAggregatesFilter? = null,
  public val details: StringWithAggregatesFilter? = null,
  public val deadline: DateTimeWithAggregatesFilter? = null,
  public val createdOn: DateTimeWithAggregatesFilter? = null,
  public val byDepartment: EnumDepartmentWithAggregatesFilter? = null,
  public val forDepartment: EnumDepartmentWithAggregatesFilter? = null,
  public val createdById: StringWithAggregatesFilter? = null,
  public val status: EnumTaskStatusWithAggregatesFilter? = null
)
