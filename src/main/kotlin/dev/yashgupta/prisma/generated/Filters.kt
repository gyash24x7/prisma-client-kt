package dev.yashgupta.prisma.generated

public data class StringFilter(
	public val equals: String,
	public val `in`: List<String>,
	public val notIn: List<String>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val mode: QueryMode,
	public val not: String
)

public data class StringNullableFilter(
	public val equals: String?,
	public val `in`: List<String?>,
	public val notIn: List<String?>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val mode: QueryMode,
	public val not: String?
)

public data class EnumDepartmentFilter(
	public val equals: Department,
	public val `in`: List<Department>,
	public val notIn: List<Department>,
	public val not: Department
)

public data class EnumUserRoleFilter(
	public val equals: UserRole,
	public val `in`: List<UserRole>,
	public val notIn: List<UserRole>,
	public val not: UserRole
)

public data class EnumDepartmentNullableFilter(
	public val equals: Department?,
	public val `in`: List<Department?>,
	public val notIn: List<Department?>,
	public val not: Department?
)

public data class BoolFilter(
	public val equals: Boolean,
	public val not: Boolean
)

public data class StringWithAggregatesFilter(
	public val equals: String,
	public val `in`: List<String>,
	public val notIn: List<String>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val mode: QueryMode,
	public val not: String,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedStringFilter,
	public val min: NestedStringFilter,
	public val _max: NestedStringFilter,
	public val max: NestedStringFilter
)

public data class StringNullableWithAggregatesFilter(
	public val equals: String?,
	public val `in`: List<String?>,
	public val notIn: List<String?>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val mode: QueryMode,
	public val not: String?,
	public val _count: NestedIntNullableFilter,
	public val count: NestedIntNullableFilter,
	public val _min: NestedStringNullableFilter,
	public val min: NestedStringNullableFilter,
	public val _max: NestedStringNullableFilter,
	public val max: NestedStringNullableFilter
)

public data class EnumDepartmentWithAggregatesFilter(
	public val equals: Department,
	public val `in`: List<Department>,
	public val notIn: List<Department>,
	public val not: Department,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedEnumDepartmentFilter,
	public val min: NestedEnumDepartmentFilter,
	public val _max: NestedEnumDepartmentFilter,
	public val max: NestedEnumDepartmentFilter
)

public data class EnumUserRoleWithAggregatesFilter(
	public val equals: UserRole,
	public val `in`: List<UserRole>,
	public val notIn: List<UserRole>,
	public val not: UserRole,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedEnumUserRoleFilter,
	public val min: NestedEnumUserRoleFilter,
	public val _max: NestedEnumUserRoleFilter,
	public val max: NestedEnumUserRoleFilter
)

public data class EnumDepartmentNullableWithAggregatesFilter(
	public val equals: Department?,
	public val `in`: List<Department?>,
	public val notIn: List<Department?>,
	public val not: Department?,
	public val _count: NestedIntNullableFilter,
	public val count: NestedIntNullableFilter,
	public val _min: NestedEnumDepartmentNullableFilter,
	public val min: NestedEnumDepartmentNullableFilter,
	public val _max: NestedEnumDepartmentNullableFilter,
	public val max: NestedEnumDepartmentNullableFilter
)

public data class BoolWithAggregatesFilter(
	public val equals: Boolean,
	public val not: Boolean,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedBoolFilter,
	public val min: NestedBoolFilter,
	public val _max: NestedBoolFilter,
	public val max: NestedBoolFilter
)

public data class NestedStringFilter(
	public val equals: String,
	public val `in`: List<String>,
	public val notIn: List<String>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val not: String
)

public data class NestedStringNullableFilter(
	public val equals: String?,
	public val `in`: List<String?>,
	public val notIn: List<String?>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val not: String?
)

public data class NestedEnumDepartmentFilter(
	public val equals: Department,
	public val `in`: List<Department>,
	public val notIn: List<Department>,
	public val not: Department
)

public data class NestedEnumUserRoleFilter(
	public val equals: UserRole,
	public val `in`: List<UserRole>,
	public val notIn: List<UserRole>,
	public val not: UserRole
)

public data class NestedEnumDepartmentNullableFilter(
	public val equals: Department?,
	public val `in`: List<Department?>,
	public val notIn: List<Department?>,
	public val not: Department?
)

public data class NestedBoolFilter(
	public val equals: Boolean,
	public val not: Boolean
)

public data class NestedStringWithAggregatesFilter(
	public val equals: String,
	public val `in`: List<String>,
	public val notIn: List<String>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val not: String,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedStringFilter,
	public val min: NestedStringFilter,
	public val _max: NestedStringFilter,
	public val max: NestedStringFilter
)

public data class NestedIntFilter(
	public val equals: Int,
	public val `in`: List<Int>,
	public val notIn: List<Int>,
	public val lt: Int,
	public val lte: Int,
	public val gt: Int,
	public val gte: Int,
	public val not: Int
)

public data class NestedStringNullableWithAggregatesFilter(
	public val equals: String?,
	public val `in`: List<String?>,
	public val notIn: List<String?>,
	public val lt: String,
	public val lte: String,
	public val gt: String,
	public val gte: String,
	public val contains: String,
	public val startsWith: String,
	public val endsWith: String,
	public val not: String?,
	public val _count: NestedIntNullableFilter,
	public val count: NestedIntNullableFilter,
	public val _min: NestedStringNullableFilter,
	public val min: NestedStringNullableFilter,
	public val _max: NestedStringNullableFilter,
	public val max: NestedStringNullableFilter
)

public data class NestedIntNullableFilter(
	public val equals: Int?,
	public val `in`: List<Int?>,
	public val notIn: List<Int?>,
	public val lt: Int,
	public val lte: Int,
	public val gt: Int,
	public val gte: Int,
	public val not: Int?
)

public data class NestedEnumDepartmentWithAggregatesFilter(
	public val equals: Department,
	public val `in`: List<Department>,
	public val notIn: List<Department>,
	public val not: Department,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedEnumDepartmentFilter,
	public val min: NestedEnumDepartmentFilter,
	public val _max: NestedEnumDepartmentFilter,
	public val max: NestedEnumDepartmentFilter
)

public data class NestedEnumUserRoleWithAggregatesFilter(
	public val equals: UserRole,
	public val `in`: List<UserRole>,
	public val notIn: List<UserRole>,
	public val not: UserRole,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedEnumUserRoleFilter,
	public val min: NestedEnumUserRoleFilter,
	public val _max: NestedEnumUserRoleFilter,
	public val max: NestedEnumUserRoleFilter
)

public data class NestedEnumDepartmentNullableWithAggregatesFilter(
	public val equals: Department?,
	public val `in`: List<Department?>,
	public val notIn: List<Department?>,
	public val not: Department?,
	public val _count: NestedIntNullableFilter,
	public val count: NestedIntNullableFilter,
	public val _min: NestedEnumDepartmentNullableFilter,
	public val min: NestedEnumDepartmentNullableFilter,
	public val _max: NestedEnumDepartmentNullableFilter,
	public val max: NestedEnumDepartmentNullableFilter
)

public data class NestedBoolWithAggregatesFilter(
	public val equals: Boolean,
	public val not: Boolean,
	public val _count: NestedIntFilter,
	public val count: NestedIntFilter,
	public val _min: NestedBoolFilter,
	public val min: NestedBoolFilter,
	public val _max: NestedBoolFilter,
	public val max: NestedBoolFilter
)