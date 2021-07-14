package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateWhereInput
import kotlin.String
import kotlin.Unit

public class DeleteManyUpdateOperation() : GraphQLOperation( "mutation" ) {
  public var `where`: UpdateWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(block: DeleteManyUpdateOperation.() -> Unit) : this() {
    val operation = DeleteManyUpdateOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "deleteManyUpdate" 
  }
}
