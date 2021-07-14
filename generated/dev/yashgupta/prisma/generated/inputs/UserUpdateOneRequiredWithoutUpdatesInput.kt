package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpdateOneRequiredWithoutUpdatesInput(
  public val create: UserCreateWithoutUpdatesInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutUpdatesInput? = null,
  public val upsert: UserUpsertWithoutUpdatesInput? = null,
  public val connect: UserWhereUniqueInput? = null,
  public val update: UserUpdateWithoutUpdatesInput? = null
)
