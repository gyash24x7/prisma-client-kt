package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserCreateInput
import kotlin.String
import kotlin.Unit

public class CreateOneUserOperation(
  `data`: UserCreateInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UserCreateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public constructor(`data`: UserCreateInput, block: CreateOneUserOperation.() -> Unit) :
      this(data) {
    val operation = CreateOneUserOperation(data).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "createOneUser" 
  }
}
