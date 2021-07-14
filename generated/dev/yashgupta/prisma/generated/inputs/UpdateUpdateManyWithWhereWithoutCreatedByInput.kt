package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUpdateManyWithWhereWithoutCreatedByInput(
  public val `where`: UpdateScalarWhereInput,
  public val `data`: UpdateUpdateManyMutationInput
)
