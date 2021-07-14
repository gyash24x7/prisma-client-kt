package dev.yashgupta.prisma.generated.outputs

import kotlinx.serialization.Serializable

@Serializable
public data class AggregateUpdate(
  public val _count: UpdateCountAggregateOutputType? = null,
  public val _min: UpdateMinAggregateOutputType? = null,
  public val _max: UpdateMaxAggregateOutputType? = null
)
