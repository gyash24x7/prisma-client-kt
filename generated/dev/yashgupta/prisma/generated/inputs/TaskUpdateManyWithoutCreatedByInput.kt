package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpdateManyWithoutCreatedByInput(
  public val create: TaskCreateWithoutCreatedByInput? = null,
  public val connectOrCreate: TaskCreateOrConnectWithoutCreatedByInput? = null,
  public val upsert: TaskUpsertWithWhereUniqueWithoutCreatedByInput? = null,
  public val createMany: TaskCreateManyCreatedByInputEnvelope? = null,
  public val connect: TaskWhereUniqueInput? = null,
  public val `set`: TaskWhereUniqueInput? = null,
  public val disconnect: TaskWhereUniqueInput? = null,
  public val delete: TaskWhereUniqueInput? = null,
  public val update: TaskUpdateWithWhereUniqueWithoutCreatedByInput? = null,
  public val updateMany: TaskUpdateManyWithWhereWithoutCreatedByInput? = null,
  public val deleteMany: TaskScalarWhereInput? = null
)
