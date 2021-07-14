package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.enums.UserScalarFieldEnum
import dev.yashgupta.prisma.generated.inputs.UserOrderByInput
import dev.yashgupta.prisma.generated.inputs.UserScalarWhereWithAggregatesInput
import dev.yashgupta.prisma.generated.inputs.UserWhereInput
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class GroupByUserOperation() : GraphQLOperation( "query" ) {
  public var `where`: UserWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var orderBy: List<UserOrderByInput>? = null
    set(`value`) {
      fieldSet+="orderBy"
          field = value
          value?.let { input["orderBy"] = value }
    }

  public var `by`: List<UserScalarFieldEnum> = emptyList()
    set(`value`) {
      fieldSet+="by"
          field = value
          value?.let { input["by"] = value }
    }

  public var having: UserScalarWhereWithAggregatesInput? = null
    set(`value`) {
      fieldSet+="having"
          field = value
          value?.let { input["having"] = value }
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

  public constructor(block: GroupByUserOperation.() -> Unit) : this() {
    val operation = GroupByUserOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
    orderBy = operation.orderBy
    having = operation.having
    take = operation.take
    skip = operation.skip
  }

  public override fun getOperationName(): String {
     return "groupByUser" 
  }
}
