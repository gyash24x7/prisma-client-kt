package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserScalarWhereWithAggregatesInput(
  public val AND: UserScalarWhereWithAggregatesInput? = null,
  public val OR: UserScalarWhereWithAggregatesInput? = null,
  public val NOT: UserScalarWhereWithAggregatesInput? = null,
  public val id: StringWithAggregatesFilter? = null,
  public val name: StringWithAggregatesFilter? = null,
  public val email: StringWithAggregatesFilter? = null,
  public val rollNumber: StringWithAggregatesFilter? = null,
  public val department: EnumDepartmentWithAggregatesFilter? = null,
  public val role: EnumUserRoleWithAggregatesFilter? = null,
  public val password: StringWithAggregatesFilter? = null,
  public val salt: StringWithAggregatesFilter? = null,
  public val profilePic: StringWithAggregatesFilter? = null,
  public val coverPic: StringWithAggregatesFilter? = null,
  public val mobile: StringWithAggregatesFilter? = null,
  public val upi: StringWithAggregatesFilter? = null,
  public val finManagerForDept: EnumDepartmentNullableWithAggregatesFilter? = null,
  public val enabled: BoolWithAggregatesFilter? = null,
  public val verified: BoolWithAggregatesFilter? = null
)
