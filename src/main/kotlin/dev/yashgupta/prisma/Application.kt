package dev.yashgupta.prisma

import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.CodegenConfig

//import dev.yashgupta.prisma.codegen.format
//import dev.yashgupta.prisma.codegen.serializeOperation
//import dev.yashgupta.prisma.generated.inputs.DateTimeFilter
//import dev.yashgupta.prisma.generated.inputs.UpdateWhereInput
//import dev.yashgupta.prisma.generated.operations.FindFirstUpdateOperation
//import kotlinx.datetime.Instant
//import kotlinx.serialization.json.encodeToJsonElement

fun main() {
	val dmmfString = object {}::class.java.classLoader.getResource("schema.json")?.readText() ?: ""

	Codegen(config = CodegenConfig(dmmf = dmmfString)).generate()
//	val findFirstUserOperation = FindFirstUpdateOperation {
//		where = UpdateWhereInput(createdOn = DateTimeFilter(equals = Instant.parse("2021-07-17T17:19:18.087Z")))
//	}
//
//	println(format.encodeToJsonElement(findFirstUserOperation))
//	println(serializeOperation(findFirstUserOperation))
}