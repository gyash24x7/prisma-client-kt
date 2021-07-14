package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserWhereInput(
  public val AND: UserWhereInput? = null,
  public val OR: UserWhereInput? = null,
  public val NOT: UserWhereInput? = null,
  public val id: StringFilter? = null,
  public val name: StringFilter? = null,
  public val email: StringFilter? = null,
  public val rollNumber: StringFilter? = null,
  public val department: EnumDepartmentFilter? = null,
  public val role: EnumUserRoleFilter? = null,
  public val password: StringFilter? = null,
  public val salt: StringFilter? = null,
  public val profilePic: StringFilter? = null,
  public val coverPic: StringFilter? = null,
  public val mobile: StringFilter? = null,
  public val upi: StringFilter? = null,
  public val finManagerForDept: EnumDepartmentNullableFilter? = null,
  public val enabled: BoolFilter? = null,
  public val verified: BoolFilter? = null,
  public val updates: UpdateListRelationFilter? = null,
  public val tasksAssigned: TaskListRelationFilter? = null,
  public val tasksCreated: TaskListRelationFilter? = null
)
