package io.prisma.codegen

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import io.prisma.client.PrismaClient
import io.prisma.client.Query
import io.prisma.client.json
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive
import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toPascalCase
import net.pearx.kasechange.toScreamingSnakeCase
import java.nio.file.Paths

class Codegen(private val config: CodegenConfig) {

	private val dmmf: DmmfDoc = json.decodeFromString(config.dmmf)
	private val serializableAnnotationSpec = AnnotationSpec.builder(Serializable::class).build()

	data class Field(val name: String, val type: TypeName, val nullable: Boolean)

	fun generate() {
		generateEnums().asSequence()
			.plus(generateOutputTypes())
			.plus(generateInputTypes())
			.plus(generateOperationInputs())
			.plus(generateSelections())
			.plus(generateModelClients())
			.forEach { it.writeTo(Paths.get(config.outputDir)) }
	}

	private fun generateEnums() = dmmf.enums.map { schemaEnum ->
		val enumSpec = TypeSpec.enumBuilder(schemaEnum.name).addAnnotation(serializableAnnotationSpec)

		schemaEnum.values.forEach {
			val serialNameAnnotation = AnnotationSpec.builder(SerialName::class)
				.addMember(""" "__enum__${schemaEnum.name.toCamelCase()}__$it" """)
				.build()

			enumSpec.addEnumConstant(
				name = it.toScreamingSnakeCase(),
				typeSpec = TypeSpec.anonymousClassBuilder().addAnnotation(serialNameAnnotation).build()
			)
		}

		FileSpec.builder(config.packageNameEnums, schemaEnum.name).addType(enumSpec.build()).build()
	}

	private fun generateType(name: String, fields: List<Field>, packageName: String): FileSpec {
		val constructorSpec = FunSpec.constructorBuilder()
		val classSpec = TypeSpec.classBuilder(name).addModifiers(KModifier.DATA).addAnnotation(serializableAnnotationSpec)

		fields.forEach { field ->
			val returnType = if (field.nullable) field.type.copy(nullable = true) else field.type
			val parameterSpec = ParameterSpec.builder(field.name, returnType)

			if (field.nullable) parameterSpec.defaultValue(CodeBlock.of("null"))

			constructorSpec.addParameter(parameterSpec.build())
			val propertySpec = PropertySpec.builder(field.name, returnType).initializer(field.name)
			classSpec.addProperty(propertySpec.build())
		}

		classSpec.primaryConstructor(constructorSpec.build())

		return FileSpec.builder(packageName, name).addType(classSpec.build()).build()
	}

	private fun generateInputTypes() = dmmf.inputs.map { inputType ->
		val fields = inputType.fields.map { field ->
			var returnType = getType(field.inputType!!.location, field.inputType!!.type)
			if (field.inputType!!.isList) returnType = LIST.parameterizedBy(returnType)
			returnType = returnType.copy(nullable = !field.isRequired)
			Field(name = field.name, nullable = !field.isRequired, type = returnType)
		}
		generateType(inputType.name, fields, config.packageNameInputs)
	}

	private fun generateOutputTypes() = dmmf.outputs.map { outputType ->
		val fields = outputType.fields.map { schemaField ->
			var type = getType(schemaField.outputType.location, schemaField.outputType.type)
			if (schemaField.outputType.isList) type = LIST.parameterizedBy(type)
			type = type.copy(nullable = schemaField.isNullable)
			Field(name = schemaField.name, type = type, nullable = schemaField.isNullable)
		}
		generateType(outputType.name, fields, config.packageNameOutputs)
	}

	private fun generateSelections() = dmmf.outputs.map { output ->
		val name = "${output.name}Selection"
		val className = ClassName(config.packageNameSelections, name)
		val primaryConstructorSpec = FunSpec.constructorBuilder()
		val classSpec = TypeSpec.classBuilder(className).addModifiers(KModifier.DATA)
			.addAnnotation(serializableAnnotationSpec)

		val defaultConstructorValues = mutableListOf<String>()

		output.fields.forEach { field ->
			val outputType = field.outputType

			lateinit var propertySpec: PropertySpec.Builder
			lateinit var parameterSpec: ParameterSpec.Builder
			if (outputType.location == "scalar" || outputType.location == "enumTypes") {
				parameterSpec = ParameterSpec.builder(field.name, Boolean::class.asClassName()).defaultValue("""false""")
				propertySpec = PropertySpec.builder(field.name, Boolean::class.asClassName()).initializer(field.name)
				defaultConstructorValues += "${field.name} = true"
			} else {
				val typeName = ClassName(config.packageNameSelections, "${outputType.type}Selection").copy(nullable = true)
				parameterSpec = ParameterSpec.builder(field.name, typeName).defaultValue("""null""")
				propertySpec = PropertySpec.builder(field.name, typeName).mutable().initializer(field.name)
				defaultConstructorValues += "${field.name} = null"
			}

			classSpec.addProperty(propertySpec.build())
			primaryConstructorSpec.addParameter(parameterSpec.build())
		}

		val companionSpec = TypeSpec.companionObjectBuilder()
			.addFunction(
				FunSpec.builder("getDefault")
					.returns(className)
					.addStatement("return %T( ${defaultConstructorValues.joinToString(", ")} )", className)
					.build()
			)

		classSpec.primaryConstructor(primaryConstructorSpec.build()).addType(companionSpec.build())
		FileSpec.builder(config.packageNameSelections, name).addType(classSpec.build()).build()
	}

	private fun generateOperationInputs() = dmmf.operations.map { operation ->
		val name = operation.name.toPascalCase() + "Input"

		val fields = operation.args.map { field ->
			var returnType = getType(field.inputType!!.location, field.inputType!!.type)
			if (field.inputType!!.isList) returnType = LIST.parameterizedBy(returnType)
			returnType = returnType.copy(nullable = !field.isRequired)
			Field(name = field.name, nullable = !field.isRequired, type = returnType)
		}
		generateType(name, fields, config.packageNameOperationInputs)
	}

	private fun generateModelClients() = dmmf.mappings.modelOperations.map {
		val modelName = it["model"]!!.jsonPrimitive.content.toPascalCase()
		val name = "${modelName}Client"
		val className = ClassName(config.packageNameClient, name)
		val constructorSpec = FunSpec.constructorBuilder()
			.addParameter(ParameterSpec.builder("prismaClient", PrismaClient::class).build())

		val classSpec = TypeSpec.classBuilder(className)
			.addProperty(PropertySpec.builder("prismaClient", PrismaClient::class).initializer("prismaClient").build())
			.primaryConstructor(constructorSpec.build())

		it.entries.filterNot { entry -> entry.key == "model" || entry.value is JsonNull }
			.forEach { entry ->
				val operation = dmmf.operations.find { input -> (entry.value as JsonPrimitive).content == input.name }
				val operationFunSpec = generateOperationFun(operation!!, modelName)
				classSpec.addFunction(operationFunSpec)
			}

		val modelPropertySpec = PropertySpec.builder(modelName.toCamelCase(), className)
			.receiver(PrismaClient::class)
			.getter(FunSpec.getterBuilder().addStatement("return %T(this)", className).build())

		FileSpec.builder(config.packageNameClient, name)
			.addType(classSpec.build())
			.addProperty(modelPropertySpec.build())
			.build()
	}

	private fun generateOperationFun(operation: SchemaField, modelName: String): FunSpec {
		val operationName = getOperationName(operation, modelName)
		val typeVariable = TypeVariableName("T").copy(reified = true)
		val funSpec = FunSpec.builder(operationName).addModifiers(KModifier.SUSPEND, KModifier.INLINE)
			.addTypeVariable(typeVariable)
			.returns(typeVariable.copy(nullable = true))

		operation.args.forEach {
			var returnType = getType(it.inputType!!.location, it.inputType!!.type)
			if (it.inputType!!.isList) returnType = LIST.parameterizedBy(returnType)
			returnType = returnType.copy(nullable = !it.isRequired)

			val paramSpec = ParameterSpec.builder(it.name, returnType)
			if (!it.isRequired) paramSpec.defaultValue("null")

			funSpec.addParameter(paramSpec.build())
		}

		val selectionClassName = ClassName(config.packageNameSelections, operation.outputType.type + "Selection")
		val selectionParameterSpec = ParameterSpec.builder("select", selectionClassName.copy(nullable = true))
			.defaultValue("null")

		funSpec.addParameter(selectionParameterSpec.build())

		funSpec.addStatement(
			"val input = %M.%M(%T( ${operation.args.joinToString(", ") { it.name }} )) as %T",
			MemberName("io.prisma.client", "json"),
			MemberName("kotlinx.serialization.json", "encodeToJsonElement"),
			ClassName(config.packageNameOperationInputs, operation.name.toPascalCase() + "Input"),
			JsonObject::class.asClassName()
		)
		funSpec.addStatement(
			"val selection = %M.%M(select?:%T.getDefault()) as %T",
			MemberName("io.prisma.client", "json"),
			MemberName("kotlinx.serialization.json", "encodeToJsonElement"),
			selectionClassName,
			JsonObject::class.asClassName()
		)
		funSpec.addStatement(
			"""val query = %T( "${getOperationType(operation.name)}", "${operation.name}", input, selection )""",
			Query::class
		)

		funSpec.addStatement("return prismaClient.execute(query)")

		return funSpec.build()
	}

	private fun getOperationType(operationName: String): String {
		val queryOperation = dmmf.queries.find { it.name == operationName }
		return if (queryOperation != null) "query" else "mutation"
	}

	private fun getOperationName(operation: SchemaField, modelName: String): String {
		val modelIndex = operation.name.indexOf(modelName)
		return operation.name.substring(0, modelIndex)
	}

	private fun getType(location: String, type: String): TypeName = when (location) {
		"scalar" -> when (type) {
			"String" -> String::class.asClassName()
			"Boolean" -> Boolean::class.asClassName()
			"Float" -> Float::class.asClassName()
			"Int" -> Int::class.asClassName()
			"BigInt" -> Long::class.asClassName()
			"Decimal" -> Double::class.asClassName()
			"DateTime" -> Instant::class.asClassName()
			else -> throw AssertionError("Unknown field type: $type")
		}
		"inputObjectTypes" -> ClassName(config.packageNameInputs, type)
		"enumTypes" -> ClassName(config.packageNameEnums, type)
		"outputObjectTypes" -> ClassName(config.packageNameOutputs, type)
		else -> throw AssertionError("Unknown field type: $type")
	}
}