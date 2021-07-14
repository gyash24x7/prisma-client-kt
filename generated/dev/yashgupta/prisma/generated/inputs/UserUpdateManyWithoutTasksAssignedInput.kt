package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpdateManyWithoutTasksAssignedInput(
  public val create: UserCreateWithoutTasksAssignedInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutTasksAssignedInput? = null,
  public val upsert: UserUpsertWithWhereUniqueWithoutTasksAssignedInput? = null,
  public val connect: UserWhereUniqueInput? = null,
  public val `set`: UserWhereUniqueInput? = null,
  public val disconnect: UserWhereUniqueInput? = null,
  public val delete: UserWhereUniqueInput? = null,
  public val update: UserUpdateWithWhereUniqueWithoutTasksAssignedInput? = null,
  public val updateMany: UserUpdateManyWithWhereWithoutTasksAssignedInput? = null,
  public val deleteMany: UserScalarWhereInput? = null
)
