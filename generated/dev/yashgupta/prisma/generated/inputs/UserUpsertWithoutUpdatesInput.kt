package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpsertWithoutUpdatesInput(
  public val update: UserUpdateWithoutUpdatesInput,
  public val create: UserCreateWithoutUpdatesInput
)
