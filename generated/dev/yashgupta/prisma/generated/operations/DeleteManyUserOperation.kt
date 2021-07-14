package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserWhereInput
import kotlin.String
import kotlin.Unit

public class DeleteManyUserOperation() : GraphQLOperation( "mutation" ) {
  public var `where`: UserWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(block: DeleteManyUserOperation.() -> Unit) : this() {
    val operation = DeleteManyUserOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "deleteManyUser" 
  }
}
