package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpdateWithWhereUniqueWithoutTasksAssignedInput(
  public val `where`: UserWhereUniqueInput,
  public val `data`: UserUpdateWithoutTasksAssignedInput
)
