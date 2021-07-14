package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserScalarWhereInput(
  public val AND: UserScalarWhereInput? = null,
  public val OR: UserScalarWhereInput? = null,
  public val NOT: UserScalarWhereInput? = null,
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
  public val verified: BoolFilter? = null
)
