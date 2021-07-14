package dev.yashgupta.prisma.generated.outputs

import kotlinx.serialization.Serializable

@Serializable
public data class AggregateTask(
  public val _count: TaskCountAggregateOutputType? = null,
  public val _min: TaskMinAggregateOutputType? = null,
  public val _max: TaskMaxAggregateOutputType? = null
)
