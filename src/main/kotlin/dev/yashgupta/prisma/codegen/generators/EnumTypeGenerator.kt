package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import dev.yashgupta.prisma.codegen.Codegen
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.pearx.kasechange.toCamelCase
import net.pearx.kasechange.toScreamingSnakeCase

fun Codegen.generateEnums() = dmmf.enums.map { schemaEnum ->
	val enumSpec = TypeSpec.enumBuilder(schemaEnum.name)
		.addAnnotation(AnnotationSpec.builder(Serializable::class).build())

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