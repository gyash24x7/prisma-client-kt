package dev.yashgupta.prisma.generated.inputs

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateManyCreatedByInputEnvelope(
  public val `data`: TaskCreateManyCreatedByInput,
  public val skipDuplicates: Boolean? = null
)
