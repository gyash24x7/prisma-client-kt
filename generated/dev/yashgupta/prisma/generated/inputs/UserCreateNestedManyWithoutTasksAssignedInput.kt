package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserCreateNestedManyWithoutTasksAssignedInput(
  public val create: UserCreateWithoutTasksAssignedInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutTasksAssignedInput? = null,
  public val connect: UserWhereUniqueInput? = null
)
