package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class DeleteOneUpdateOperation(
  `where`: UpdateWhereUniqueInput
) : GraphQLOperation( "mutation" ) {
  public var `where`: UpdateWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`where`: UpdateWhereUniqueInput, block: DeleteOneUpdateOperation.() -> Unit) :
      this(where) {
    val operation = DeleteOneUpdateOperation(where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "deleteOneUpdate" 
  }
}
