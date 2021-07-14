package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserCreateNestedOneWithoutUpdatesInput(
  public val create: UserCreateWithoutUpdatesInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutUpdatesInput? = null,
  public val connect: UserWhereUniqueInput? = null
)
