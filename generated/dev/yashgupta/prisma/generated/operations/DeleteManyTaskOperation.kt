package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskWhereInput
import kotlin.String
import kotlin.Unit

public class DeleteManyTaskOperation() : GraphQLOperation( "mutation" ) {
  public var `where`: TaskWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(block: DeleteManyTaskOperation.() -> Unit) : this() {
    val operation = DeleteManyTaskOperation().apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "deleteManyTask" 
  }
}
