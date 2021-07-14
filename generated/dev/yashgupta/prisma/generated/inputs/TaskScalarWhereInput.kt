package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskScalarWhereInput(
  public val AND: TaskScalarWhereInput? = null,
  public val OR: TaskScalarWhereInput? = null,
  public val NOT: TaskScalarWhereInput? = null,
  public val id: StringFilter? = null,
  public val brief: StringFilter? = null,
  public val details: StringFilter? = null,
  public val deadline: DateTimeFilter? = null,
  public val createdOn: DateTimeFilter? = null,
  public val byDepartment: EnumDepartmentFilter? = null,
  public val forDepartment: EnumDepartmentFilter? = null,
  public val createdById: StringFilter? = null,
  public val status: EnumTaskStatusFilter? = null
)
