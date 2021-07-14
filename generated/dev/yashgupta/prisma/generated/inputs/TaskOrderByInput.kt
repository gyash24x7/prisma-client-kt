package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.SortOrder
import kotlinx.serialization.Serializable

@Serializable
public data class TaskOrderByInput(
  public val id: SortOrder? = null,
  public val brief: SortOrder? = null,
  public val details: SortOrder? = null,
  public val deadline: SortOrder? = null,
  public val createdOn: SortOrder? = null,
  public val byDepartment: SortOrder? = null,
  public val forDepartment: SortOrder? = null,
  public val createdById: SortOrder? = null,
  public val status: SortOrder? = null
)
