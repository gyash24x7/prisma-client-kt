package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.TaskCreateInput
import dev.yashgupta.prisma.generated.inputs.TaskUpdateInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereUniqueInput
import kotlin.String
import kotlin.Unit

public class UpsertOneTaskOperation(
  `where`: TaskWhereUniqueInput,
  create: TaskCreateInput,
  update: TaskUpdateInput
) : GraphQLOperation( "mutation" ) {
  public var `where`: TaskWhereUniqueInput = where
    set(`value`) {
      fieldSet+="where"
          field = value
          value?.let { input["where"] = value }
    }

  public var create: TaskCreateInput = create
    set(`value`) {
      fieldSet+="create"
          field = value
          value?.let { input["create"] = value }
    }

  public var update: TaskUpdateInput = update
    set(`value`) {
      fieldSet+="update"
          field = value
          value?.let { input["update"] = value }
    }

  public constructor(
    `where`: TaskWhereUniqueInput,
    create: TaskCreateInput,
    update: TaskUpdateInput,
    block: UpsertOneTaskOperation.() -> Unit
  ) : this(where, create, update) {
    val operation = UpsertOneTaskOperation(where, create, update).apply(block)
    fieldSet = operation.fieldSet
  }

  public override fun getOperationName(): String {
     return "upsertOneTask" 
  }
}
