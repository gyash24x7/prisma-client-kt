package dev.yashgupta.prisma

//import dev.yashgupta.prisma.codegen.Codegen
//import dev.yashgupta.prisma.codegen.CodegenConfig

import dev.yashgupta.prisma.client.PrismaClient
import dev.yashgupta.prisma.client.Query
import dev.yashgupta.prisma.client.json
import dev.yashgupta.prisma.client.serialize
import dev.yashgupta.prisma.generated.enums.TaskScalarFieldEnum
import dev.yashgupta.prisma.generated.inputs.DateTimeFilter
import dev.yashgupta.prisma.generated.inputs.FindFirstTaskInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereInput
import dev.yashgupta.prisma.generated.selections.TaskSelection
import dev.yashgupta.prisma.generated.selections.UpdateSelection
import dev.yashgupta.prisma.generated.selections.UserSelection
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Instant
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement

fun main() {
	val dmmfString = object {}::class.java.classLoader.getResource("schema.json")?.readText() ?: ""

//	Codegen(config = CodegenConfig(dmmf = dmmfString)).generate()
	val findFirstTaskInput = FindFirstTaskInput {
		where = TaskWhereInput(createdOn = DateTimeFilter(equals = Instant.parse("2021-07-17T17:19:18.087Z")))
		distinct = listOf(TaskScalarFieldEnum.ID)
	}

	val select = TaskSelection(createdBy = UserSelection(updates = UpdateSelection()))
	val inputJson = json.encodeToJsonElement(findFirstTaskInput) as JsonObject
	val selectionJson = json.encodeToJsonElement(select) as JsonObject

	val query = Query(
		name = "findFirstTask",
		type = "query",
		input = inputJson,
		selection = selectionJson
	)

	println(json.encodeToJsonElement(inputJson))
	println(json.encodeToJsonElement(selectionJson))
	println(query.serialize())
	val prisma = PrismaClient()
	runBlocking {
		val response = prisma.execute(query)
		println(response)
	}
}