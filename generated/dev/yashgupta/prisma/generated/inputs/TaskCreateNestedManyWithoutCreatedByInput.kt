package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskCreateNestedManyWithoutCreatedByInput(
  public val create: TaskCreateWithoutCreatedByInput? = null,
  public val connectOrCreate: TaskCreateOrConnectWithoutCreatedByInput? = null,
  public val createMany: TaskCreateManyCreatedByInputEnvelope? = null,
  public val connect: TaskWhereUniqueInput? = null
)
