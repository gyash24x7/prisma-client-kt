package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class TaskUpdateManyWithoutAssignedToInput(
  public val create: TaskCreateWithoutAssignedToInput? = null,
  public val connectOrCreate: TaskCreateOrConnectWithoutAssignedToInput? = null,
  public val upsert: TaskUpsertWithWhereUniqueWithoutAssignedToInput? = null,
  public val connect: TaskWhereUniqueInput? = null,
  public val `set`: TaskWhereUniqueInput? = null,
  public val disconnect: TaskWhereUniqueInput? = null,
  public val delete: TaskWhereUniqueInput? = null,
  public val update: TaskUpdateWithWhereUniqueWithoutAssignedToInput? = null,
  public val updateMany: TaskUpdateManyWithWhereWithoutAssignedToInput? = null,
  public val deleteMany: TaskScalarWhereInput? = null
)
