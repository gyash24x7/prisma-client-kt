package dev.yashgupta.prisma.codegen

import java.nio.file.Path
import java.nio.file.Paths

data class CodegenConfig(
	val outputDir: Path = Paths.get("build", "generated"),
	val packageName: String = "dev.yashgupta.prisma.generated",
	val maxProjectionDepth: Int = 10,
	val dmmf: String = ""
) {
	val packageNameClient: String = "$packageName.client"
	val packageNameOperations: String = "$packageName.operations"
	val packageNameEnums: String = "$packageName.enums"
	val packageNameInputs: String = "$packageName.inputs"
	val packageNameOutputs: String = "$packageName.outputs"
}
