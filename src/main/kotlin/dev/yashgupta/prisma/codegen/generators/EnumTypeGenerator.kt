package dev.yashgupta.prisma.codegen.generators

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import dev.yashgupta.prisma.codegen.Codegen
import net.pearx.kasechange.toScreamingSnakeCase

fun Codegen.generateEnums() = dmmf.schema.enumTypes.model.plus(dmmf.schema.enumTypes.prisma).map { schemaEnum ->
	val enumSpec = TypeSpec.enumBuilder(schemaEnum.name)
		.primaryConstructor(FunSpec.constructorBuilder().addParameter("_name", String::class).build())

	schemaEnum.values.forEach {
		enumSpec.addEnumConstant(
			name = it.toScreamingSnakeCase(),
			typeSpec = TypeSpec.anonymousClassBuilder().addSuperclassConstructorParameter("%S", it).build()
		)
	}

	val fileSpec = FileSpec.builder(config.packageNameEnums, schemaEnum.name).addType(enumSpec.build())
	fileSpec.build()
}