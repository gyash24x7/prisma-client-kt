package dev.yashgupta.prisma

//import dev.yashgupta.prisma.codegen.Codegen
//import dev.yashgupta.prisma.codegen.CodegenConfig

import dev.yashgupta.prisma.client.Request
import dev.yashgupta.prisma.client.json
import dev.yashgupta.prisma.client.serializeRequest
import dev.yashgupta.prisma.generated.enums.TaskScalarFieldEnum
import dev.yashgupta.prisma.generated.inputs.DateTimeFilter
import dev.yashgupta.prisma.generated.inputs.FindFirstTaskInput
import dev.yashgupta.prisma.generated.inputs.TaskWhereInput
import dev.yashgupta.prisma.generated.selections.TaskSelectInput
import dev.yashgupta.prisma.generated.selections.UpdateSelectInput
import dev.yashgupta.prisma.generated.selections.UserSelectInput
import dev.yashgupta.prisma.generated.selections.args.UpdateListArgs
import dev.yashgupta.prisma.generated.selections.args.UserArgs
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

	val select = TaskSelectInput(
		createdBy = UserArgs(
			select = UserSelectInput(
				updates = UpdateListArgs(
					select = UpdateSelectInput()
//					where = UpdateWhereInput(
//						id = StringFilter(
//							equals = "update-id"
//						)
//					)
				)
			)
		)
	)
	val inputJson = json.encodeToJsonElement(findFirstTaskInput) as JsonObject
	val selectionJson = json.encodeToJsonElement(select) as JsonObject

	val request = Request(
		name = "findFirstTask",
		type = "query",
		input = inputJson,
		selection = selectionJson
	)

	println(serializeRequest(request))
}