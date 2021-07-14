package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserUpdateManyMutationInput
import dev.yashgupta.prisma.generated.inputs.UserWhereInput
import kotlin.String
import kotlin.Unit

public class UpdateManyUserOperation(
  `data`: UserUpdateManyMutationInput
) : GraphQLOperation( "mutation" ) {
  public var `data`: UserUpdateManyMutationInput = data
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var `where`: UserWhereInput? = null
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public constructor(`data`: UserUpdateManyMutationInput, block: UpdateManyUserOperation.() -> Unit)
      : this(data) {
    val operation = UpdateManyUserOperation(data).apply(block)
    fieldSet = operation.fieldSet
    where = operation.where
  }

  public override fun getOperationName(): String {
     return "updateManyUser" 
  }
}
