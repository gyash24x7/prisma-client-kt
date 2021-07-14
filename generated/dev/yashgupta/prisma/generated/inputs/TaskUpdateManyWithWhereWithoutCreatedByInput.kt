package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpdateManyWithWhereWithoutCreatedByInput(
  public val `where`: TaskScalarWhereInput,
  public val `data`: TaskUpdateManyMutationInput
)
