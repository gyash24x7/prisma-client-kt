package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateOrderByInput
import dev.yashgupta.prisma.generated.inputs.UpdateWhereInput
import dev.yashgupta.prisma.generated.inputs.UpdateWhereUniqueInput
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class AggregateUpdateOperation() : GraphQLOperation( "query" ) {
  public var `where`: UpdateWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var orderBy: List<UpdateOrderByInput>? = null
    set(`value`) {
      fieldSet+="orderBy"
          field = value
          value?.let { input["orderBy"] = value }
    }

  public var cursor: UpdateWhereUniqueInput? = null
    set(`value`) {
      fieldSet+="cursor"
          field = value
          value?.let { input["cursor"] = value }
    }

  public var take: Int? = null
    set(`value`) {
      fieldSet+="take"
          field = value
          value?.let { input["take"] = value }
    }

  public var skip: Int? = null
    set(`value`) {
      fieldSet+="skip"
          field = value
          value?.let { input["skip"] = value }
    }

  public constructor(block: AggregateUpdateOperation.() -> Unit) : this() {
    val operation = AggregateUpdateOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
    orderBy = operation.orderBy
    cursor = operation.cursor
    take = operation.take
    skip = operation.skip
  }

  public override fun getOperationName(): String {
     return "aggregateUpdate" 
  }
}
