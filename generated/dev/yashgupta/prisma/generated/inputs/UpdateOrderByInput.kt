package dev.yashgupta.prisma.generated.inputs

import dev.yashgupta.prisma.generated.enums.SortOrder
import kotlinx.serialization.Serializable

@Serializable
public data class UpdateOrderByInput(
  public val id: SortOrder? = null,
  public val brief: SortOrder? = null,
  public val subject: SortOrder? = null,
  public val details: SortOrder? = null,
  public val createdOn: SortOrder? = null,
  public val createdById: SortOrder? = null,
  public val byDept: SortOrder? = null
)
