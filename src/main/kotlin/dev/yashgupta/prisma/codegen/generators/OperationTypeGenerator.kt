package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.yashgupta.prisma.SchemaField
import dev.yashgupta.prisma.codegen.Codegen
import dev.yashgupta.prisma.codegen.GraphQLOperation
import dev.yashgupta.prisma.codegen.getType
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toPascalCase

fun Codegen.generateOperation(operation: SchemaField, operationType: String): FileSpec {
	val name = operation.name.toPascalCase() + "Operation"
	val className = ClassName(config.packageNameOperations, name)
	val classSpec = TypeSpec.classBuilder(className)
		.addSuperinterface(GraphQLOperation::class)
		.addAnnotation(AnnotationSpec.builder(Serializable::class).build())

	val primaryConstructorParamString = operation.args.mapNotNull {
		if (it.isRequired && !it.inputType!!.isList) it.name else null
	}.joinToString(", ")

	val operationNamePropertySpec = PropertySpec.builder("name", String::class)
		.addModifiers(KModifier.OVERRIDE)
		.addAnnotation(AnnotationSpec.builder(Transient::class).build())
		.initializer(""" "${operation.name.toCamelCase()}" """)

	val operationTypePropertySpec = PropertySpec.builder("type", String::class)
		.addModifiers(KModifier.OVERRIDE)
		.addAnnotation(AnnotationSpec.builder(Transient::class).build())
		.initializer(""" "$operationType" """)

	val primaryConstructorSpec = FunSpec.constructorBuilder()
	val secondaryConstructorSpec = FunSpec.constructorBuilder()
		.addStatement("""val operation = ${name}(${primaryConstructorParamString}).apply(block)""")
		.callThisConstructor(primaryConstructorParamString)

	operation.args.forEach { arg ->
		var returnType = getType(arg.inputType!!.location, arg.inputType!!.type)
		if (arg.inputType!!.isList) returnType = LIST.parameterizedBy(returnType)
		returnType = returnType.copy(nullable = !arg.isRequired)

		val argPropertySpec = PropertySpec.builder(arg.name, returnType).mutable(true)

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

	classSpec.addProperty(operationTypePropertySpec.build())
	classSpec.addProperty(operationNamePropertySpec.build())
	classSpec.primaryConstructor(primaryConstructorSpec.build())
	classSpec.addFunction(secondaryConstructorSpec.build())

	val fileSpec = FileSpec.builder(config.packageNameOperations, name).addType(classSpec.build())
	return fileSpec.build()
}

fun Codegen.generateQueries() = dmmf.queries.map { generateOperation(it, "query") }

fun Codegen.generateMutations() = dmmf.mutations.map { generateOperation(it, "mutation") }
