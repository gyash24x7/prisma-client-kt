package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateOrConnectWithoutAssignedToInput(
  public val `where`: TaskWhereUniqueInput,
  public val create: TaskCreateWithoutAssignedToInput
)
