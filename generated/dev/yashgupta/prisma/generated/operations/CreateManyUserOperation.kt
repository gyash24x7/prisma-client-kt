package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UserCreateManyInput
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class CreateManyUserOperation() : GraphQLOperation( "mutation" ) {
  public var `data`: List<UserCreateManyInput> = emptyList()
    set(`value`) {
      fieldSet+="data"
          field = value
          value?.let { input["data"] = value }
    }

  public var skipDuplicates: Boolean? = null
    set(`value`) {
      fieldSet+="skipDuplicates"
          field = value
          value?.let { input["skipDuplicates"] = value }
    }

  public constructor(block: CreateManyUserOperation.() -> Unit) : this() {
    val operation = CreateManyUserOperation().apply(block)
    fieldSet = operation.fieldSet
    skipDuplicates = operation.skipDuplicates
  }

  public override fun getOperationName(): String {
     return "createManyUser" 
  }
}
