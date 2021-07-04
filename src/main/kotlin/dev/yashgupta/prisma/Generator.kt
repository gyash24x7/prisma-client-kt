package dev.yashgupta.prisma

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import dev.yashgupta.prisma.utils.camelCaseToLowerSnakeCase
import java.nio.file.Path


class Generator(private val document: Document) {

	private val path: Path = Path.of("src/main/kotlin")
	private val packageName = "dev.yashgupta.prisma.generated"
	private val builtInTypes = listOf("String", "Boolean", "Int", "Double")

	fun generateEnums() {
		val enumList = document.schema.enumTypes.model + document.schema.enumTypes.prisma

		val fileBuilder = FileSpec.builder(packageName = packageName, fileName = "Enums")

		enumList.forEach { schemaEnum ->

			val enumBuilder = TypeSpec.enumBuilder(name = schemaEnum.name)
				.primaryConstructor(FunSpec.constructorBuilder().addParameter("_name", String::class).build())

			schemaEnum.values.forEach { enumValue ->
				enumBuilder.addEnumConstant(
					name = enumValue.camelCaseToLowerSnakeCase().uppercase(),
					typeSpec = TypeSpec.anonymousClassBuilder()
						.addSuperclassConstructorParameter("%S", enumValue)
						.build()
				)
			}

			fileBuilder.addType(enumBuilder.build())
		}

		fileBuilder.build().writeTo(path)
	}

	fun generateFilters() {
		val filters = document.getInputs()

		val fileBuilder = FileSpec.builder(packageName = packageName, fileName = "Inputs")

		filters.forEach { filter ->

			val classBuilder = TypeSpec.classBuilder(filter.name).addModifiers(KModifier.DATA)
			val constructorBuilder = FunSpec.constructorBuilder()

			filter.fields.forEach { schemaArg ->
				val inputType = schemaArg.inputType!!
				val baseClassName = if (builtInTypes.contains(inputType.type)) {
					ClassName("kotlin", inputType.type).copy(nullable = !schemaArg.isRequired)
				} else {
					ClassName(packageName, inputType.type).copy(nullable = !schemaArg.isRequired)
				}

				val className = if (inputType.isList) {
					ClassName("kotlin.collections", "List").plusParameter(baseClassName)
						.copy(nullable = !schemaArg.isRequired)
				} else baseClassName

				val parameterBuilder = ParameterSpec.builder(schemaArg.name, className)

				constructorBuilder.addParameter(parameterBuilder.build())
				classBuilder.addProperty(
					PropertySpec.builder(schemaArg.name, className)
						.initializer(schemaArg.name)
						.build()
				)
			}

			classBuilder.primaryConstructor(constructorBuilder.build())
			fileBuilder.addType(classBuilder.build())
		}

		fileBuilder.build().writeTo(path)
	}

}