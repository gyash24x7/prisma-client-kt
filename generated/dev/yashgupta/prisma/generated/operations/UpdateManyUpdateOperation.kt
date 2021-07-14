package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateUpdateManyMutationInput
import dev.yashgupta.prisma.generated.inputs.UpdateWhereInput
import kotlin.String
import kotlin.Unit

public class UpdateManyUpdateOperation(
  `data`: UpdateUpdateManyMutationInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UpdateUpdateManyMutationInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: UpdateWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`data`: UpdateUpdateManyMutationInput, block: UpdateManyUpdateOperation.() ->
      Unit) : this(data) {
    val operation = UpdateManyUpdateOperation(data).apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "updateManyUpdate" 
  }
}
