package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpdateManyWithWhereWithoutAssignedToInput(
  public val `where`: TaskScalarWhereInput,
  public val `data`: TaskUpdateManyMutationInput
)
