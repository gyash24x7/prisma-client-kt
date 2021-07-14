package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpsertWithoutTasksCreatedInput(
  public val update: UserUpdateWithoutTasksCreatedInput,
  public val create: UserCreateWithoutTasksCreatedInput
)
