package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.codegen.getKtpType
import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toPascalCase

fun Codegen.generateOperations() = dmmf.getOperations().map { (operationType, operation) ->
	val name = operation.name.toPascalCase() + "Operation"
	val className = ClassName(config.packageNameOperations, name)
	val classSpec = TypeSpec.classBuilder(className).superclass(GraphQLOperation::class)
		.addSuperclassConstructorParameter(""" "${operationType.toCamelCase()}" """)

	val primaryConstructorParamString = operation.args.mapNotNull {
		if (it.isRequired && !it.inputType!!.isList) it.name else null
	}.joinToString(", ")

	val primaryConstructorSpec = FunSpec.constructorBuilder()
	val secondaryConstructorSpec = FunSpec.constructorBuilder()
		.addStatement("""val operation = ${name}(${primaryConstructorParamString}).apply(block)""")
		.addStatement("""fieldSet = operation.fieldSet""")
		.callThisConstructor(primaryConstructorParamString)

	classSpec.addFunction(
		FunSpec.builder("getOperationName")
			.addModifiers(KModifier.OVERRIDE)
			.returns(String::class)
			.addCode(""" return "${operation.name}" """)
			.build()
	)

	operation.args.forEach { arg ->
		var returnType = getKtpType(arg.inputType!!.location, arg.inputType!!.type)
		if (arg.inputType!!.isList) returnType = LIST.parameterizedBy(returnType)
		returnType = returnType.copy(nullable = !arg.isRequired)

		val argSetterFunSpec = FunSpec.setterBuilder()
			.addParameter("value", returnType)
			.addStatement(
				"""
					fieldSet+="${arg.name}"
					field = value
					value?.let { input["${arg.name}"] = value }
				""".trimIndent()
			)

		val argPropertySpec = PropertySpec.builder(arg.name, returnType)
			.mutable(true).setter(argSetterFunSpec.build())

		if (!arg.isRequired) {
			argPropertySpec.initializer("""null""")
			secondaryConstructorSpec.addStatement("""${arg.name} = operation.${arg.name}""")
		} else if (arg.inputType!!.isList) {
			argPropertySpec.initializer("""emptyList()""")
		} else {
			argPropertySpec.initializer(arg.name)
			val argParamSpec = ParameterSpec.builder(arg.name, returnType)
			primaryConstructorSpec.addParameter(argParamSpec.build())
			secondaryConstructorSpec.addParameter(argParamSpec.build())
		}

		classSpec.addProperty(argPropertySpec.build())
	}

	val builderLambdaSpec = LambdaTypeName.get(className, emptyList(), Unit::class.asTypeName())
	secondaryConstructorSpec.addParameter(ParameterSpec.builder("block", builderLambdaSpec).build())

	classSpec.primaryConstructor(primaryConstructorSpec.build())
	classSpec.addFunction(secondaryConstructorSpec.build())

	val fileSpec = FileSpec.builder(config.packageNameOperations, name).addType(classSpec.build())
	fileSpec.build()
}
