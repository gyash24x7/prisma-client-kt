package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateCreateInput
import dev.yashgupta.prisma.generated.inputs.UpdateUpdateInput
import dev.yashgupta.prisma.generated.inputs.UpdateWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpsertOneUpdateOperation(
  `where`: UpdateWhereUniqueInput,
  create: UpdateCreateInput,
  update: UpdateUpdateInput
) : GraphQLOperation( "mutation" ) {
  public var `where`: UpdateWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var create: UpdateCreateInput = create
    set(`value`) {
      fieldSet+="create"
          field = value
          value?.let { input["create"] = value }
    }

  public var update: UpdateUpdateInput = update
    set(`value`) {
      fieldSet+="update"
          field = value
          value?.let { input["update"] = value }
    }

  public constructor(
    `where`: UpdateWhereUniqueInput,
    create: UpdateCreateInput,
    update: UpdateUpdateInput,
    block: UpsertOneUpdateOperation.() -> Unit
  ) : this(where, create, update) {
    val operation = UpsertOneUpdateOperation(where, create, update).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "upsertOneUpdate" 
  }
}
