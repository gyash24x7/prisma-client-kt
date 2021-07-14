package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpsertWithWhereUniqueWithoutAssignedToInput(
  public val `where`: TaskWhereUniqueInput,
  public val update: TaskUpdateWithoutAssignedToInput,
  public val create: TaskCreateWithoutAssignedToInput
)
