package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserCreateInput
import dev.yashgupta.prisma.generated.inputs.UserUpdateInput
import dev.yashgupta.prisma.generated.inputs.UserWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpsertOneUserOperation(
  `where`: UserWhereUniqueInput,
  create: UserCreateInput,
  update: UserUpdateInput
) : GraphQLOperation( "mutation" ) {
  public var `where`: UserWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var create: UserCreateInput = create
    set(`value`) {
      fieldSet+="create"
          field = value
          value?.let { input["create"] = value }
    }

  public var update: UserUpdateInput = update
    set(`value`) {
      fieldSet+="update"
          field = value
          value?.let { input["update"] = value }
    }

  public constructor(
    `where`: UserWhereUniqueInput,
    create: UserCreateInput,
    update: UserUpdateInput,
    block: UpsertOneUserOperation.() -> Unit
  ) : this(where, create, update) {
    val operation = UpsertOneUserOperation(where, create, update).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "upsertOneUser" 
  }
}
