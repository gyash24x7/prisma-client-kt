package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateCreateOrConnectWithoutCreatedByInput(
  public val `where`: UpdateWhereUniqueInput,
  public val create: UpdateCreateWithoutCreatedByInput
)
