package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUncheckedCreateNestedManyWithoutCreatedByInput(
  public val create: UpdateCreateWithoutCreatedByInput? = null,
  public val connectOrCreate: UpdateCreateOrConnectWithoutCreatedByInput? = null,
  public val createMany: UpdateCreateManyCreatedByInputEnvelope? = null,
  public val connect: UpdateWhereUniqueInput? = null
)
