package dev.yashgupta.prisma.generated.operations

import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.generated.inputs.UpdateCreateManyInput
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class CreateManyUpdateOperation() : GraphQLOperation( "mutation" ) {
  public var `data`: List<UpdateCreateManyInput> = emptyList()
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

  public constructor(block: CreateManyUpdateOperation.() -> Unit) : this() {
    val operation = CreateManyUpdateOperation().apply(block)
    fieldSet = operation.fieldSet
    skipDuplicates = operation.skipDuplicates
  }

  public override fun getOperationName(): String {
     return "createManyUpdate" 
  }
}
