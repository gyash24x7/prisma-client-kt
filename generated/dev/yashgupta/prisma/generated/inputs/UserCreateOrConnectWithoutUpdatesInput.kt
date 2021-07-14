package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserCreateOrConnectWithoutUpdatesInput(
  public val `where`: UserWhereUniqueInput,
  public val create: UserCreateWithoutUpdatesInput
)
