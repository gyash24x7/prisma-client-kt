package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateScalarWhereInput(
  public val AND: UpdateScalarWhereInput? = null,
  public val OR: UpdateScalarWhereInput? = null,
  public val NOT: UpdateScalarWhereInput? = null,
  public val id: StringFilter? = null,
  public val brief: StringFilter? = null,
  public val subject: StringFilter? = null,
  public val details: StringFilter? = null,
  public val createdOn: DateTimeFilter? = null,
  public val createdById: StringFilter? = null,
  public val byDept: EnumDepartmentFilter? = null
)
