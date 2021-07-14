package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlinx.serialization.Serializable

@Serializable
public data class NestedEnumDepartmentNullableWithAggregatesFilter(
  public val equals: Department? = null,
  public val `in`: Department? = null,
  public val notIn: Department? = null,
  public val not: Department? = null,
  public val _count: NestedIntNullableFilter? = null,
  public val _min: NestedEnumDepartmentNullableFilter? = null,
  public val _max: NestedEnumDepartmentNullableFilter? = null
)
