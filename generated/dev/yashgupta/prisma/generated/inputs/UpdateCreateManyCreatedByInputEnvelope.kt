package dev.yashgupta.prisma.generated.inputs

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public data class UpdateCreateManyCreatedByInputEnvelope(
  public val `data`: UpdateCreateManyCreatedByInput,
  public val skipDuplicates: Boolean? = null
)
