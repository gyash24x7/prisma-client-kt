package dev.yashgupta.prisma

//import dev.yashgupta.prisma.codegen.Codegen
//import dev.yashgupta.prisma.codegen.CodegenConfig

import dev.yashgupta.prisma.codegen.GraphQLRequest
import dev.yashgupta.prisma.generated.enums.SortOrder
import dev.yashgupta.prisma.generated.inputs.StringFilter
import dev.yashgupta.prisma.generated.inputs.UserOrderByInput
import dev.yashgupta.prisma.generated.inputs.UserWhereInput
import dev.yashgupta.prisma.generated.operations.FindFirstUserOperation

fun main() {
	val dmmfString = object {}::class.java.classLoader.getResource("schema.json")?.readText() ?: ""

//	Codegen(config = CodegenConfig(dmmf = dmmfString)).generate()
	val findFirstUserOperation = FindFirstUserOperation {
		where = UserWhereInput(name = StringFilter(contains = "Yash"))
		orderBy = listOf(UserOrderByInput(id = SortOrder.ASC))
	}

	println(findFirstUserOperation)

	val request = GraphQLRequest(findFirstUserOperation)

	println(request.serialize())
}