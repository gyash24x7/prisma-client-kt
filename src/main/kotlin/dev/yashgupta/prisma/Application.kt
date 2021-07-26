package dev.yashgupta.prisma

//import dev.yashgupta.prisma.codegen.Codegen
//import dev.yashgupta.prisma.codegen.CodegenConfig

import dev.yashgupta.prisma.client.PrismaClient
import dev.yashgupta.prisma.generated.client.task
import dev.yashgupta.prisma.generated.selections.TaskSelection
import kotlinx.coroutines.runBlocking

fun main() {
//	val dmmfString = object {}::class.java.classLoader.getResource("schema.json")?.readText() ?: ""
//	Codegen(config = CodegenConfig(dmmf = dmmfString)).generate()

	val prisma = PrismaClient()
	runBlocking {
		val response = prisma.task.findFirst(
			select = TaskSelection(id = true)
		)
		println(response)
	}
}