package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUpsertWithWhereUniqueWithoutCreatedByInput(
  public val `where`: UpdateWhereUniqueInput,
  public val update: UpdateUpdateWithoutCreatedByInput,
  public val create: UpdateCreateWithoutCreatedByInput
)
