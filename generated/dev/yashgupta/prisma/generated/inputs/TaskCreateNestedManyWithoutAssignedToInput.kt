package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateNestedManyWithoutAssignedToInput(
  public val create: TaskCreateWithoutAssignedToInput? = null,
  public val connectOrCreate: TaskCreateOrConnectWithoutAssignedToInput? = null,
  public val connect: TaskWhereUniqueInput? = null
)
