package dev.yashgupta.prisma.dmmf

class Dmmf(private val document: Document) {

	fun getFilters(): List<InputType> {
		val inputObjectTypes = document.schema.inputObjectTypes.prisma.toMutableList()

		if (document.schema.inputObjectTypes.model.isNotEmpty()) {
			inputObjectTypes += document.schema.inputObjectTypes.model
		}

		return inputObjectTypes.filter { it.name.endsWith("Filter") }.map {
			it.apply {
				fields.map { field -> field.apply { inputType = field.inputTypes[0] } }
			}
		}
	}
}