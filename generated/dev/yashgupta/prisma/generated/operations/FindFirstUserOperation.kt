package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.enums.UserScalarFieldEnum
import dev.yashgupta.prisma.generated.inputs.UserOrderByInput
import dev.yashgupta.prisma.generated.inputs.UserWhereInput
import dev.yashgupta.prisma.generated.inputs.UserWhereUniqueInput
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class FindFirstUserOperation() : GraphQLOperation( "query" ) {
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

  public var cursor: UserWhereUniqueInput? = null
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

  public var distinct: List<UserScalarFieldEnum>? = null
    set(`value`) {
      fieldSet+="distinct"
          field = value
          value?.let { input["distinct"] = value }
    }

  public constructor(block: FindFirstUserOperation.() -> Unit) : this() {
    val operation = FindFirstUserOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
    orderBy = operation.orderBy
    cursor = operation.cursor
    take = operation.take
    skip = operation.skip
    distinct = operation.distinct
  }

  public override fun getOperationName(): String {
     return "findFirstUser" 
  }
}
