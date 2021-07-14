package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskCreateInput
import kotlin.String
import kotlin.Unit

public class CreateOneTaskOperation(
  `data`: TaskCreateInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: TaskCreateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public constructor(`data`: TaskCreateInput, block: CreateOneTaskOperation.() -> Unit) :
      this(data) {
    val operation = CreateOneTaskOperation(data).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "createOneTask" 
  }
}
