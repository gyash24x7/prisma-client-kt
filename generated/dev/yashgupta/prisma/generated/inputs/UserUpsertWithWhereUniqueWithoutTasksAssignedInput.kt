package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserUpsertWithWhereUniqueWithoutTasksAssignedInput(
  public val `where`: UserWhereUniqueInput,
  public val update: UserUpdateWithoutTasksAssignedInput,
  public val create: UserCreateWithoutTasksAssignedInput
)
