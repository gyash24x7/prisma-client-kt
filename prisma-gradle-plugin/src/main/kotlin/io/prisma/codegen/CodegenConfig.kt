package io.prisma.codegen

import java.nio.file.Path
import java.nio.file.Paths

data class CodegenConfig(val dmmf: String = "", val outputDir: Path = Paths.get("build", "generated")) {
	private val packageName: String = "io.prisma.generated"
	val packageNameClient: String = "$packageName.client"
	val packageNameEnums: String = "$packageName.enums"
	val packageNameInputs: String = "$packageName.inputs"
	val packageNameOutputs: String = "$packageName.outputs"
	val packageNameSelections: String = "$packageName.selections"
	val packageNameSelectionArgs: String = "$packageNameSelections.args"
	val packageNameOperationInputs: String = "$packageNameInputs.operations"
	val packageNameOperations: String = "$packageName.operations"
}
