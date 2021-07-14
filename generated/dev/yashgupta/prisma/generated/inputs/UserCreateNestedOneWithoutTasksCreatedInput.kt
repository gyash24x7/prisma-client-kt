package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UserCreateNestedOneWithoutTasksCreatedInput(
  public val create: UserCreateWithoutTasksCreatedInput? = null,
  public val connectOrCreate: UserCreateOrConnectWithoutTasksCreatedInput? = null,
  public val connect: UserWhereUniqueInput? = null
)
