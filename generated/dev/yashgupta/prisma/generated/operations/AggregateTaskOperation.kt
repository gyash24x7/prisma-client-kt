package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskOrderByInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereUniqueInput
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class AggregateTaskOperation() : GraphQLOperation( "query" ) {
  public var `where`: TaskWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var orderBy: List<TaskOrderByInput>? = null
    set(`value`) {
      fieldSet+="orderBy"
          field = value
          value?.let { input["orderBy"] = value }
    }

  public var cursor: TaskWhereUniqueInput? = null
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

  public constructor(block: AggregateTaskOperation.() -> Unit) : this() {
    val operation = AggregateTaskOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
    orderBy = operation.orderBy
    cursor = operation.cursor
    take = operation.take
    skip = operation.skip
  }

  public override fun getOperationName(): String {
     return "aggregateTask" 
  }
}
