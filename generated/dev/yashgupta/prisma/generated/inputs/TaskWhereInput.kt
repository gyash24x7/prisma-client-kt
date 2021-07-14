package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskWhereInput(
  public val AND: TaskWhereInput? = null,
  public val OR: TaskWhereInput? = null,
  public val NOT: TaskWhereInput? = null,
  public val id: StringFilter? = null,
  public val brief: StringFilter? = null,
  public val details: StringFilter? = null,
  public val deadline: DateTimeFilter? = null,
  public val createdOn: DateTimeFilter? = null,
  public val byDepartment: EnumDepartmentFilter? = null,
  public val forDepartment: EnumDepartmentFilter? = null,
  public val createdBy: UserRelationFilter? = null,
  public val createdById: StringFilter? = null,
  public val assignedTo: UserListRelationFilter? = null,
  public val status: EnumTaskStatusFilter? = null
)
