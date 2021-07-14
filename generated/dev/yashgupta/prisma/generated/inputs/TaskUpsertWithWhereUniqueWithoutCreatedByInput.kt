package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpsertWithWhereUniqueWithoutCreatedByInput(
  public val `where`: TaskWhereUniqueInput,
  public val update: TaskUpdateWithoutCreatedByInput,
  public val create: TaskCreateWithoutCreatedByInput
)
