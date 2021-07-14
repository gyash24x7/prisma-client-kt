package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateUpdateInput
import dev.yashgupta.prisma.generated.inputs.UpdateWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpdateOneUpdateOperation(
  `data`: UpdateUpdateInput,
  `where`: UpdateWhereUniqueInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UpdateUpdateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: UpdateWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(
    `data`: UpdateUpdateInput,
    `where`: UpdateWhereUniqueInput,
    block: UpdateOneUpdateOperation.() -> Unit
  ) : this(data, where) {
    val operation = UpdateOneUpdateOperation(data, where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "updateOneUpdate" 
  }
}
