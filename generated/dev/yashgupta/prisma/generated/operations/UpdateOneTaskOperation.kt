package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskUpdateInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpdateOneTaskOperation(
  `data`: TaskUpdateInput,
  `where`: TaskWhereUniqueInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: TaskUpdateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: TaskWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(
    `data`: TaskUpdateInput,
    `where`: TaskWhereUniqueInput,
    block: UpdateOneTaskOperation.() -> Unit
  ) : this(data, where) {
    val operation = UpdateOneTaskOperation(data, where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "updateOneTask" 
  }
}
