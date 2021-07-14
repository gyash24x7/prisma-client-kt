package dev.yashgupta.prisma.generated.outputs

import kotlinx.serialization.Serializable

@Serializable
public data class AggregateUser(
  public val _count: UserCountAggregateOutputType? = null,
  public val _min: UserMinAggregateOutputType? = null,
  public val _max: UserMaxAggregateOutputType? = null
)
