package dev.yashgupta.prisma.codegen

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.yashgupta.prisma.client.json
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toPascalCase
import net.pearx.kasechange.toScreamingSnakeCase

class Codegen(val config: CodegenConfig) {

	val dmmf: DmmfDoc = json.decodeFromString(config.dmmf)
	val serializableAnnotationSpec = AnnotationSpec.builder(Serializable::class).build()

	data class Field(val name: String, val type: TypeName, val nullable: Boolean)

	fun generate() {
		generateEnums().asSequence()
			.plus(generateOutputTypes())
			.plus(generateInputTypes())
			.plus(generateOperationInputs())
			.plus(generateSelections())
			.forEach { it.writeTo(config.outputDir) }
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

		val fileSpec = FileSpec.builder(config.packageNameEnums, schemaEnum.name).addType(enumSpec.build())
		fileSpec.build()
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

		val fileSpec = FileSpec.builder(packageName, name).addType(classSpec.build())
		return fileSpec.build()
	}

	private fun generateInputTypes() = dmmf.inputs.map { inputType ->
		val fields = inputType.fields.map { field ->
			val type = getType(field.inputType!!.location, field.inputType!!.type)
			Field(name = field.name, nullable = !field.isRequired, type = type)
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

		output.fields.forEach { schemaField ->
			lateinit var propertySpec: PropertySpec.Builder
			lateinit var parameterSpec: ParameterSpec.Builder
			if (schemaField.outputType.location == "scalar" || schemaField.outputType.location == "enumTypes") {
				parameterSpec = ParameterSpec.builder(schemaField.name, Boolean::class.asClassName()).defaultValue("""true""")
				propertySpec = PropertySpec.builder(schemaField.name, Boolean::class.asClassName()).mutable()
					.initializer(schemaField.name)
			} else {
				val typeName = ClassName(config.packageNameSelections, "${schemaField.outputType.type}Selection")
					.copy(nullable = true)
				parameterSpec = ParameterSpec.builder(schemaField.name, typeName).defaultValue("""null""")
				propertySpec = PropertySpec.builder(schemaField.name, typeName).mutable().initializer(schemaField.name)
			}

			classSpec.addProperty(propertySpec.build())
			primaryConstructorSpec.addParameter(parameterSpec.build())
		}

		classSpec.primaryConstructor(primaryConstructorSpec.build())
		val fileSpec = FileSpec.builder(config.packageNameSelections, name).addType(classSpec.build())
		fileSpec.build()
	}

	private fun generateOperationInputs() = dmmf.operationInputs.map { operation ->
		val name = operation.name.toPascalCase() + "Input"
		val className = ClassName(config.packageNameInputs, name)
		val classSpec = TypeSpec.classBuilder(className).addAnnotation(serializableAnnotationSpec)

		val primaryConstructorParamString = operation.args.mapNotNull {
			if (it.isRequired && !it.inputType!!.isList) it.name else null
		}.joinToString(", ")

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

		classSpec.primaryConstructor(primaryConstructorSpec.build())
		classSpec.addFunction(secondaryConstructorSpec.build())

		val fileSpec = FileSpec.builder(config.packageNameInputs, name).addType(classSpec.build())
		fileSpec.build()
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