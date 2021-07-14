package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.Department
import kotlinx.serialization.Serializable

@Serializable
public data class EnumDepartmentFilter(
  public val equals: Department? = null,
  public val `in`: Department? = null,
  public val notIn: Department? = null,
  public val not: Department? = null
)
