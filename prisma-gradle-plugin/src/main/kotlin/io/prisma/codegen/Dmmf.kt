package io.prisma.codegen

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

@Serializable
data class DmmfDoc(
	var datamodel: Datamodel,
	var schema: Schema,
	var mappings: Mappings
) {
	private val deprecatedAggregates = listOf("count", "min", "max")

	val models = schema.outputObjectTypes.model

	val enums = schema.enumTypes.model.plus(schema.enumTypes.prisma)

	val inputs = schema.inputObjectTypes.prisma.plus(schema.inputObjectTypes.model)
		.map { input ->
			input.apply {
				fields = fields.filter { !deprecatedAggregates.contains(it.name) }
					.map { field -> field.apply { inputType = inputTypes[0] } }
			}
		}

	val outputs = schema.outputObjectTypes.prisma.plus(schema.outputObjectTypes.model)
		.filter { !listOf("Query", "Mutation").contains(it.name) }
		.map { output ->
			output.apply {
				fields = fields.filter { !deprecatedAggregates.contains(it.name) || output.name == "AffectedRowsOutput" }
			}
		}

	val queries = schema.outputObjectTypes.prisma.plus(schema.outputObjectTypes.model)
		.filter { it.name == "Query" }
		.flatMap {
			it.fields.map { field ->
				field.apply { args = args.map { arg -> arg.apply { inputType = inputTypes[0] } } }
			}
		}

	val mutations = schema.outputObjectTypes.prisma.plus(schema.outputObjectTypes.model)
		.filter { it.name == "Mutation" }
		.flatMap {
			it.fields.map { field ->
				field.apply { args = args.map { arg -> arg.apply { inputType = inputTypes[0] } } }
			}
		}

	val operations = queries + mutations
}


@Serializable
data class Mappings(
	var modelOperations: List<JsonObject>,
	var otherOperations: OtherOperationMappings
)

@Serializable
data class OtherOperationMappings(
	var read: List<String>,
	var write: List<String>
)

@Serializable
data class DatamodelEnum(
	var name: String,
	var values: List<EnumValue>,
	var dbName: String? = null,
	var documentation: String? = null
)

@Serializable
data class SchemaEnum(
	var name: String,
	var values: List<String>
)

@Serializable
data class EnumValue(
	var name: String,
	var dbName: String? = null
)

@Serializable
data class Datamodel(
	var models: List<Model>,
	var enums: List<DatamodelEnum>
)

@Serializable
data class UniqueIndex(
	var name: String,
	var fields: List<String>
)

@Serializable
data class Model(
	var name: String,
	var isEmbedded: Boolean,
	var isGenerated: Boolean,
	var dbName: String? = null,
	var fields: List<Field>,
	var fieldMap: Map<String, Field>? = HashMap(),
	var uniqueFields: List<List<String>>,
	var uniqueIndexes: List<UniqueIndex>,
	var documentation: String? = null,
	var idFields: List<String>
)

@Serializable
data class Field(
	var kind: String, //values -> scalar, object, enum, unsupported
	var name: String,
	var isRequired: Boolean,
	var isList: Boolean,
	var isUnique: Boolean,
	var isId: Boolean,
	var type: String,
	var dbNames: List<String> = emptyList(),
	var isGenerated: Boolean,
	var isReadOnly: Boolean,
	var isUpdatedAt: Boolean,
	var hasDefaultValue: Boolean,
	var default: JsonElement? = null, // originally Any
	var relationToFields: List<String> = emptyList(), //originally Any
	var relationFromFields: List<String> = emptyList(), //originally Any
	var relationOnDelete: String? = null,
	var relationName: String? = null,
	var documentation: String? = null
)

@Serializable
data class FieldDefault(
	var name: String,
	var args: List<String> // originally any
)

@Serializable
data class SchemaInputObjectTypes(
	var model: List<InputType> = emptyList(),
	var prisma: List<InputType> = emptyList()
)

@Serializable
data class SchemaOutputObjectTypes(
	var model: List<OutputType> = emptyList(),
	var prisma: List<OutputType> = emptyList()
)

@Serializable
data class SchemaEnumTypes(
	var model: List<SchemaEnum> = emptyList(),
	var prisma: List<SchemaEnum>
)

@Serializable
data class Schema(
	var rootQueryType: String? = null,
	var rootMutationType: String? = null,
	var inputObjectTypes: SchemaInputObjectTypes,
	var outputObjectTypes: SchemaOutputObjectTypes,
	var enumTypes: SchemaEnumTypes
)

@Serializable
data class SchemaArgInputType(
	var isList: Boolean,
	var location: String, // values -> scalar, inputObjectTypes, outputObjectTypes, enumTypes
	var namespace: String? = null, // values -> model, prisma
	var type: String, // refers to some other custom type or primitive type
)

@Serializable
data class SchemaArg(
	var name: String,
	var comment: String? = null,
	var isNullable: Boolean,
	var isRequired: Boolean,
	var inputTypes: List<SchemaArgInputType>,
	var deprecation: Deprecation? = null,
	var inputType: SchemaArgInputType? = null,
	var hasSelfReference: Boolean = false
)

@Serializable
data class OutputType(
	var name: String,
	var fields: List<SchemaField>,
	var fieldMap: Map<String, SchemaField> = HashMap(),
	var isEmbedded: Boolean = false
)

@Serializable
data class SchemaFieldOutputType(
	var isList: Boolean,
	var location: String, // values -> scalar, inputObjectTypes, outputObjectTypes, enumTypes
	var namespace: String? = null,  // values -> model, prisma
	var type: String, // refers to some other custom type or primitive type
)

@Serializable
data class SchemaField(
	var name: String,
	var isNullable: Boolean = false,
	var args: List<SchemaArg>,
	var deprecation: Deprecation? = null,
	var outputType: SchemaFieldOutputType
)

@Serializable
data class Deprecation(
	var sinceVersion: String,
	var reason: String,
	var plannedRemovalVersion: String? = null
)

@Serializable
data class InputTypeConstraints(
	var maxNumFields: Int? = null,
	var minNumFields: Int? = null
)

@Serializable
data class InputType(
	var name: String,
	var constraints: InputTypeConstraints,
	var fields: List<SchemaArg>,
	var fieldMap: Map<String, SchemaArg> = HashMap(),
)

@Serializable
data class ModelMapping(
	var model: String,
	var plural: String? = null,
	var findUnique: String? = null,
	var findFirst: String? = null,
	var findMany: String? = null,
	var create: String? = null,
	var createOne: String? = null,
	var createMany: String? = null,
	var update: String? = null,
	var updateOne: String? = null,
	var updateMany: String? = null,
	var upsert: String? = null,
	var upsertOne: String? = null,
	var delete: String? = null,
	var deleteOne: String? = null,
	var deleteMany: String? = null,
	var aggregate: String? = null,
	var groupBy: String? = null,
	var count: String? = null
)

enum class ModelAction(var action: String) {
	FindUnique("findUnique"),
	FindFirst("findFirst"),
	FindMany("findMany"),
	Create("create"),
	CreateOne("createOne"),
	CreateMany("createMany"),
	Update("update"),
	UpdateOne("updateOne"),
	UpdateMany("updateMany"),
	Upsert("upsert"),
	UpsertOne("upsertOne"),
	Delete("delete"),
	DeleteOne("deleteOne"),
	DeleteMany("deleteMany"),
	GroupBy("groupBy"),
	Count("count"),
	Aggregate("aggregate")
}