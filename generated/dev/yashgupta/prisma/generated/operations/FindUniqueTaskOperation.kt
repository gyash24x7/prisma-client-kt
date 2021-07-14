package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class FindUniqueTaskOperation(
  `where`: TaskWhereUniqueInput
) : GraphQLOperation( "query" ) {
  public var `where`: TaskWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`where`: TaskWhereUniqueInput, block: FindUniqueTaskOperation.() -> Unit) :
      this(where) {
    val operation = FindUniqueTaskOperation(where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "findUniqueTask" 
  }
}
