package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateOrConnectWithoutCreatedByInput(
  public val `where`: TaskWhereUniqueInput,
  public val create: TaskCreateWithoutCreatedByInput
)
