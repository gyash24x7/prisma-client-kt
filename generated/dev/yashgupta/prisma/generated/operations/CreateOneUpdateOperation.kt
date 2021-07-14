package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateCreateInput
import kotlin.String
import kotlin.Unit

public class CreateOneUpdateOperation(
  `data`: UpdateCreateInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UpdateCreateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public constructor(`data`: UpdateCreateInput, block: CreateOneUpdateOperation.() -> Unit) :
      this(data) {
    val operation = CreateOneUpdateOperation(data).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "createOneUpdate" 
  }
}
