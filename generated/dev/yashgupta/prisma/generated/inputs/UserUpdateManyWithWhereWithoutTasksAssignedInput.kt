package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpdateManyWithWhereWithoutTasksAssignedInput(
  public val `where`: UserScalarWhereInput,
  public val `data`: UserUpdateManyMutationInput
)
