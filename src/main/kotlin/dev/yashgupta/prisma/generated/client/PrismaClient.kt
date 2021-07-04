package dev.yashgupta.prisma.generated.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

class PrismaClient {
	val client = HttpClient(CIO)
}