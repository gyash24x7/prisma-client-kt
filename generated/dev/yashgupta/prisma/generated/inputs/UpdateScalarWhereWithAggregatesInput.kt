package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateScalarWhereWithAggregatesInput(
  public val AND: UpdateScalarWhereWithAggregatesInput? = null,
  public val OR: UpdateScalarWhereWithAggregatesInput? = null,
  public val NOT: UpdateScalarWhereWithAggregatesInput? = null,
  public val id: StringWithAggregatesFilter? = null,
  public val brief: StringWithAggregatesFilter? = null,
  public val subject: StringWithAggregatesFilter? = null,
  public val details: StringWithAggregatesFilter? = null,
  public val createdOn: DateTimeWithAggregatesFilter? = null,
  public val createdById: StringWithAggregatesFilter? = null,
  public val byDept: EnumDepartmentWithAggregatesFilter? = null
)
