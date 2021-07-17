package dev.yashgupta.prisma

import dev.yashgupta.prisma.generated.inputs.UserWhereUniqueInput
import dev.yashgupta.prisma.generated.operations.FindUniqueUserOperation
import dev.yashgupta.prisma.generated.outputs.User
import io.ktor.client.*

class PrismaClient {

	lateinit var client: HttpClient
	val user: UserClient = UserClient()

	fun connect() {
		TODO("Launch Prisma Query Engine, fetch connection details and initialise client")
	}

	fun disconnect() {
		TODO("Shut down prisma query engine process")
	}
}

class UserClient {

	fun findUnique(where: UserWhereUniqueInput, block: FindUniqueUserOperation.() -> Unit): User? {
		val operation = FindUniqueUserOperation(where, block)
		return null
	}
}

//
val prisma = PrismaClient()
val user = prisma.user.findUnique(where = UserWhereUniqueInput(id = "bcd")) {}