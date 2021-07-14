package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpdateOneRequiredWithoutTasksCreatedInput(
  public val create: UserCreateWithoutTasksCreatedInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutTasksCreatedInput? = null,
  public val upsert: UserUpsertWithoutTasksCreatedInput? = null,
  public val connect: UserWhereUniqueInput? = null,
  public val update: UserUpdateWithoutTasksCreatedInput? = null
)
