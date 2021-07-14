package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskUpdateManyMutationInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereInput
import kotlin.String
import kotlin.Unit

public class UpdateManyTaskOperation(
  `data`: TaskUpdateManyMutationInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: TaskUpdateManyMutationInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: TaskWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`data`: TaskUpdateManyMutationInput, block: UpdateManyTaskOperation.() -> Unit)
      : this(data) {
    val operation = UpdateManyTaskOperation(data).apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "updateManyTask" 
  }
}
