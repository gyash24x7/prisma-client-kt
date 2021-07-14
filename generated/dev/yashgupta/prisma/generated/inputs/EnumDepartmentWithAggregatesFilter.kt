package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlinx.serialization.Serializable

@Serializable
public data class EnumDepartmentWithAggregatesFilter(
  public val equals: Department? = null,
  public val `in`: Department? = null,
  public val notIn: Department? = null,
  public val not: Department? = null,
  public val _count: NestedIntFilter? = null,
  public val _min: NestedEnumDepartmentFilter? = null,
  public val _max: NestedEnumDepartmentFilter? = null
)
