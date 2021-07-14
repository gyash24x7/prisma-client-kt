package dev.yashgupta.prisma.generated.inputs

import kotlinx.serialization.Serializable

@Serializable
public data class UpdateUncheckedUpdateManyWithoutCreatedByInput(
  public val create: UpdateCreateWithoutCreatedByInput? = null,
  public val connectOrCreate: UpdateCreateOrConnectWithoutCreatedByInput? = null,
  public val upsert: UpdateUpsertWithWhereUniqueWithoutCreatedByInput? = null,
  public val createMany: UpdateCreateManyCreatedByInputEnvelope? = null,
  public val connect: UpdateWhereUniqueInput? = null,
  public val `set`: UpdateWhereUniqueInput? = null,
  public val disconnect: UpdateWhereUniqueInput? = null,
  public val delete: UpdateWhereUniqueInput? = null,
  public val update: UpdateUpdateWithWhereUniqueWithoutCreatedByInput? = null,
  public val updateMany: UpdateUpdateManyWithWhereWithoutCreatedByInput? = null,
  public val deleteMany: UpdateScalarWhereInput? = null
)
