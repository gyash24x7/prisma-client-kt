package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserCreateOrConnectWithoutTasksAssignedInput(
  public val `where`: UserWhereUniqueInput,
  public val create: UserCreateWithoutTasksAssignedInput
)
