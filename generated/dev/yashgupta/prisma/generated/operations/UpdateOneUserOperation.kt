package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserUpdateInput
import dev.yashgupta.prisma.generated.inputs.UserWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpdateOneUserOperation(
  `data`: UserUpdateInput,
  `where`: UserWhereUniqueInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UserUpdateInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: UserWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(
    `data`: UserUpdateInput,
    `where`: UserWhereUniqueInput,
    block: UpdateOneUserOperation.() -> Unit
  ) : this(data, where) {
    val operation = UpdateOneUserOperation(data, where).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "updateOneUser" 
  }
}
