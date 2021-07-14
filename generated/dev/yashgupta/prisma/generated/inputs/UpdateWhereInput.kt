package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateWhereInput(
  public val AND: UpdateWhereInput? = null,
  public val OR: UpdateWhereInput? = null,
  public val NOT: UpdateWhereInput? = null,
  public val id: StringFilter? = null,
  public val brief: StringFilter? = null,
  public val subject: StringFilter? = null,
  public val details: StringFilter? = null,
  public val createdOn: DateTimeFilter? = null,
  public val createdBy: UserRelationFilter? = null,
  public val createdById: StringFilter? = null,
  public val byDept: EnumDepartmentFilter? = null
)
