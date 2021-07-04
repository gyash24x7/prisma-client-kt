package dev.yashgupta.prisma.generated

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

public data class UserWhereInput(
  public val AND: UserWhereInput?,
  public val OR: List<UserWhereInput?>?,
  public val NOT: UserWhereInput?,
  public val id: StringFilter?,
  public val name: StringFilter?,
  public val email: StringFilter?,
  public val rollNumber: StringFilter?,
  public val department: EnumDepartmentFilter?,
  public val role: EnumUserRoleFilter?,
  public val password: StringFilter?,
  public val salt: StringFilter?,
  public val profilePic: StringFilter?,
  public val coverPic: StringFilter?,
  public val mobile: StringFilter?,
  public val upi: StringFilter?,
  public val finManagerForDept: EnumDepartmentNullableFilter?,
  public val enabled: BoolFilter?,
  public val verified: BoolFilter?
)

public data class UserOrderByInput(
  public val id: SortOrder?,
  public val name: SortOrder?,
  public val email: SortOrder?,
  public val rollNumber: SortOrder?,
  public val department: SortOrder?,
  public val role: SortOrder?,
  public val password: SortOrder?,
  public val salt: SortOrder?,
  public val profilePic: SortOrder?,
  public val coverPic: SortOrder?,
  public val mobile: SortOrder?,
  public val upi: SortOrder?,
  public val finManagerForDept: SortOrder?,
  public val enabled: SortOrder?,
  public val verified: SortOrder?
)

public data class UserWhereUniqueInput(
  public val id: String?,
  public val email: String?,
  public val rollNumber: String?,
  public val salt: String?
)

public data class UserScalarWhereWithAggregatesInput(
  public val AND: UserScalarWhereWithAggregatesInput?,
  public val OR: List<UserScalarWhereWithAggregatesInput?>?,
  public val NOT: UserScalarWhereWithAggregatesInput?,
  public val id: StringWithAggregatesFilter?,
  public val name: StringWithAggregatesFilter?,
  public val email: StringWithAggregatesFilter?,
  public val rollNumber: StringWithAggregatesFilter?,
  public val department: EnumDepartmentWithAggregatesFilter?,
  public val role: EnumUserRoleWithAggregatesFilter?,
  public val password: StringWithAggregatesFilter?,
  public val salt: StringWithAggregatesFilter?,
  public val profilePic: StringWithAggregatesFilter?,
  public val coverPic: StringWithAggregatesFilter?,
  public val mobile: StringWithAggregatesFilter?,
  public val upi: StringWithAggregatesFilter?,
  public val finManagerForDept: EnumDepartmentNullableWithAggregatesFilter?,
  public val enabled: BoolWithAggregatesFilter?,
  public val verified: BoolWithAggregatesFilter?
)

public data class UserCreateInput(
  public val id: String?,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole?,
  public val password: String,
  public val salt: String,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserUncheckedCreateInput(
  public val id: String?,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole?,
  public val password: String,
  public val salt: String,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserUpdateInput(
  public val id: String?,
  public val name: String?,
  public val email: String?,
  public val rollNumber: String?,
  public val department: Department?,
  public val role: UserRole?,
  public val password: String?,
  public val salt: String?,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String?,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserUncheckedUpdateInput(
  public val id: String?,
  public val name: String?,
  public val email: String?,
  public val rollNumber: String?,
  public val department: Department?,
  public val role: UserRole?,
  public val password: String?,
  public val salt: String?,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String?,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserCreateManyInput(
  public val id: String?,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole?,
  public val password: String,
  public val salt: String,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserUpdateManyMutationInput(
  public val id: String?,
  public val name: String?,
  public val email: String?,
  public val rollNumber: String?,
  public val department: Department?,
  public val role: UserRole?,
  public val password: String?,
  public val salt: String?,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String?,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class UserUncheckedUpdateManyInput(
  public val id: String?,
  public val name: String?,
  public val email: String?,
  public val rollNumber: String?,
  public val department: Department?,
  public val role: UserRole?,
  public val password: String?,
  public val salt: String?,
  public val profilePic: String?,
  public val coverPic: String?,
  public val mobile: String?,
  public val upi: String?,
  public val finManagerForDept: Department?,
  public val enabled: Boolean?,
  public val verified: Boolean?
)

public data class StringFilter(
  public val equals: String?,
  public val `in`: List<String?>?,
  public val notIn: List<String?>?,
  public val lt: String?,
  public val lte: String?,
  public val gt: String?,
  public val gte: String?,
  public val contains: String?,
  public val startsWith: String?,
  public val endsWith: String?,
  public val mode: QueryMode?,
  public val not: String?
)

public data class EnumDepartmentFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?
)

public data class EnumUserRoleFilter(
  public val equals: UserRole?,
  public val `in`: List<UserRole?>?,
  public val notIn: List<UserRole?>?,
  public val not: UserRole?
)

public data class EnumDepartmentNullableFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?
)

public data class BoolFilter(
  public val equals: Boolean?,
  public val not: Boolean?
)

public data class StringWithAggregatesFilter(
  public val equals: String?,
  public val `in`: List<String?>?,
  public val notIn: List<String?>?,
  public val lt: String?,
  public val lte: String?,
  public val gt: String?,
  public val gte: String?,
  public val contains: String?,
  public val startsWith: String?,
  public val endsWith: String?,
  public val mode: QueryMode?,
  public val not: String?,
  public val _count: NestedIntFilter?,
  public val _min: NestedStringFilter?,
  public val _max: NestedStringFilter?
)

public data class EnumDepartmentWithAggregatesFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?,
  public val _count: NestedIntFilter?,
  public val _min: NestedEnumDepartmentFilter?,
  public val _max: NestedEnumDepartmentFilter?
)

public data class EnumUserRoleWithAggregatesFilter(
  public val equals: UserRole?,
  public val `in`: List<UserRole?>?,
  public val notIn: List<UserRole?>?,
  public val not: UserRole?,
  public val _count: NestedIntFilter?,
  public val _min: NestedEnumUserRoleFilter?,
  public val _max: NestedEnumUserRoleFilter?
)

public data class EnumDepartmentNullableWithAggregatesFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?,
  public val _count: NestedIntNullableFilter?,
  public val _min: NestedEnumDepartmentNullableFilter?,
  public val _max: NestedEnumDepartmentNullableFilter?
)

public data class BoolWithAggregatesFilter(
  public val equals: Boolean?,
  public val not: Boolean?,
  public val _count: NestedIntFilter?,
  public val _min: NestedBoolFilter?,
  public val _max: NestedBoolFilter?
)

public data class StringFieldUpdateOperationsInput(
  public val `set`: String?
)

public data class EnumDepartmentFieldUpdateOperationsInput(
  public val `set`: Department?
)

public data class EnumUserRoleFieldUpdateOperationsInput(
  public val `set`: UserRole?
)

public data class NullableEnumDepartmentFieldUpdateOperationsInput(
  public val `set`: Department?
)

public data class BoolFieldUpdateOperationsInput(
  public val `set`: Boolean?
)

public data class NestedStringFilter(
  public val equals: String?,
  public val `in`: List<String?>?,
  public val notIn: List<String?>?,
  public val lt: String?,
  public val lte: String?,
  public val gt: String?,
  public val gte: String?,
  public val contains: String?,
  public val startsWith: String?,
  public val endsWith: String?,
  public val not: String?
)

public data class NestedEnumDepartmentFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?
)

public data class NestedEnumUserRoleFilter(
  public val equals: UserRole?,
  public val `in`: List<UserRole?>?,
  public val notIn: List<UserRole?>?,
  public val not: UserRole?
)

public data class NestedEnumDepartmentNullableFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?
)

public data class NestedBoolFilter(
  public val equals: Boolean?,
  public val not: Boolean?
)

public data class NestedStringWithAggregatesFilter(
  public val equals: String?,
  public val `in`: List<String?>?,
  public val notIn: List<String?>?,
  public val lt: String?,
  public val lte: String?,
  public val gt: String?,
  public val gte: String?,
  public val contains: String?,
  public val startsWith: String?,
  public val endsWith: String?,
  public val not: String?,
  public val _count: NestedIntFilter?,
  public val _min: NestedStringFilter?,
  public val _max: NestedStringFilter?
)

public data class NestedIntFilter(
  public val equals: Int?,
  public val `in`: List<Int?>?,
  public val notIn: List<Int?>?,
  public val lt: Int?,
  public val lte: Int?,
  public val gt: Int?,
  public val gte: Int?,
  public val not: Int?
)

public data class NestedEnumDepartmentWithAggregatesFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?,
  public val _count: NestedIntFilter?,
  public val _min: NestedEnumDepartmentFilter?,
  public val _max: NestedEnumDepartmentFilter?
)

public data class NestedEnumUserRoleWithAggregatesFilter(
  public val equals: UserRole?,
  public val `in`: List<UserRole?>?,
  public val notIn: List<UserRole?>?,
  public val not: UserRole?,
  public val _count: NestedIntFilter?,
  public val _min: NestedEnumUserRoleFilter?,
  public val _max: NestedEnumUserRoleFilter?
)

public data class NestedEnumDepartmentNullableWithAggregatesFilter(
  public val equals: Department?,
  public val `in`: List<Department?>?,
  public val notIn: List<Department?>?,
  public val not: Department?,
  public val _count: NestedIntNullableFilter?,
  public val _min: NestedEnumDepartmentNullableFilter?,
  public val _max: NestedEnumDepartmentNullableFilter?
)

public data class NestedIntNullableFilter(
  public val equals: Int?,
  public val `in`: List<Int?>?,
  public val notIn: List<Int?>?,
  public val lt: Int?,
  public val lte: Int?,
  public val gt: Int?,
  public val gte: Int?,
  public val not: Int?
)

public data class NestedBoolWithAggregatesFilter(
  public val equals: Boolean?,
  public val not: Boolean?,
  public val _count: NestedIntFilter?,
  public val _min: NestedBoolFilter?,
  public val _max: NestedBoolFilter?
)
