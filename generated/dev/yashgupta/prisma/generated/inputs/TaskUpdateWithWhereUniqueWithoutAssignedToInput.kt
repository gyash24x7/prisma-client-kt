package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpdateWithWhereUniqueWithoutAssignedToInput(
  public val `where`: TaskWhereUniqueInput,
  public val `data`: TaskUpdateWithoutAssignedToInput
)
