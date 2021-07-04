package dev.yashgupta.prisma.utils

val splitKeywords = listOf(
	"CreateInput",
	"CreateMany",
	"CreateNested",
	"CreateOneWithout",
	"CreateOrConnect",
	"CreateWithout",
	"DistinctField",
	"Filter",
	"ManyWithout",
	"OrderByInput",
	"RelationFilter",
	"ListRelationFilter",
	"ScalarWhereInput",
	"UpdateInput",
	"UpdateMany",
	"UpdateOneRequiredWithout",
	"UpdateOneWithout",
	"UpdateWith",
	"UpsertWith",
	"UpsertWithout",
	"WhereInput",
	"WhereUniqueInput",
	"AvgAggregate",
	"SumAggregate",
	"MinAggregate",
	"MaxAggregate",
	"CountAggregate",
	"ScalarField",
	"GroupBy",
	"OrderBy",
	"UncheckedUpdate",
	"UncheckedCreate",
	"ScalarWhere",
	"CountOutputType",
	"CountOrderBy",
	"SumOrderBy",
	"MinOrderBy",
	"MaxOrderBy",
	"AvgOrderBy"
).sorted()

val endsWithKeywords = listOf(
	"Aggregate",
	"GroupBy",
	"CreateOne",
	"DeleteMany",
	"DeleteOne",
	"FindMany",
	"FindOne",
	"FindUnique",
	"UpdateMany",
	"UpdateOne",
	"UpsertOne"
).sorted()

val middleKeywords = listOf(
	Pair("Aggregate", "Args"),
	Pair("CreateOne", "Args"),
	Pair("DeleteMany", "Args"),
	Pair("DeleteOne", "Args"),
	Pair("FindMany", "Args"),
	Pair("FindFirst", "Args"),
	Pair("FindOne", "Args"),
	Pair("FindUnique", "Args"),
	Pair("UpdateMany", "Args"),
	Pair("UpdateOne", "Args"),
	Pair("UpsertOne", "Args"),
	Pair("GroupBy", "Args"),
	Pair("OrderBy", "Args"),
)

fun getModelName(name: String, modelNames: List<String>): String? {
	for (keyword in splitKeywords) {
		val test = name.split(keyword)[0]
		if (modelNames.contains(test)) {
			return test
		}
	}

	for (keyword in endsWithKeywords) {
		val test = name.split(keyword).reversed()[0]
		if (modelNames.contains(test)) {
			return test
		}
	}

	for ((start, end) in middleKeywords) {
		val test = name.slice(start.length until name.length - end.length)
		if (modelNames.contains(test)) {
			return test
		}
	}

	if (name.endsWith("Count", true)) {
		val test = name.slice(0 until name.length - 5)
		if (modelNames.contains(test)) {
			return test
		}
	}

	return null
}