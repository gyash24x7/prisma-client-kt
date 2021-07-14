package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class DeleteOneUserOperation(
  `where`: UserWhereUniqueInput
) : GraphQLOperation( "mutation" ) {
  public var `where`: UserWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`where`: UserWhereUniqueInput, block: DeleteOneUserOperation.() -> Unit) :
      this(where) {
    val operation = DeleteOneUserOperation(where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "deleteOneUser" 
  }
}
