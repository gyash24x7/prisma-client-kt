package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.*
import kotlinx.serialization.Serializable

data class Field(val name: String, val type: TypeName, val nullable: Boolean)

fun generateType(name: String, fields: List<Field>, packageName: String): FileSpec {

	val constructorSpec = FunSpec.constructorBuilder()
	val classSpec = TypeSpec.classBuilder(name).addModifiers(KModifier.DATA)
		.addAnnotation(AnnotationSpec.builder(Serializable::class).build())

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