package dev.yashgupta.prisma.generated

import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class AggregateUser(
  public val _count: UserCountAggregateOutputType?,
  public val _min: UserMinAggregateOutputType?,
  public val _max: UserMaxAggregateOutputType?
)

public data class UserGroupByOutputType(
  public val id: String,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole,
  public val password: String,
  public val salt: String,
  public val profilePic: String,
  public val coverPic: String,
  public val mobile: String,
  public val upi: String,
  public val finManagerForDept: Department?,
  public val enabled: Boolean,
  public val verified: Boolean,
  public val _count: UserCountAggregateOutputType?,
  public val _min: UserMinAggregateOutputType?,
  public val _max: UserMaxAggregateOutputType?
)

public data class AffectedRowsOutput(
  public val count: Int
)

public data class UserCountAggregateOutputType(
  public val id: Int,
  public val name: Int,
  public val email: Int,
  public val rollNumber: Int,
  public val department: Int,
  public val role: Int,
  public val password: Int,
  public val salt: Int,
  public val profilePic: Int,
  public val coverPic: Int,
  public val mobile: Int,
  public val upi: Int,
  public val finManagerForDept: Int,
  public val enabled: Int,
  public val verified: Int,
  public val _all: Int
)

public data class UserMinAggregateOutputType(
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

public data class UserMaxAggregateOutputType(
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

public data class User(
  public val id: String,
  public val name: String,
  public val email: String,
  public val rollNumber: String,
  public val department: Department,
  public val role: UserRole,
  public val password: String,
  public val salt: String,
  public val profilePic: String,
  public val coverPic: String,
  public val mobile: String,
  public val upi: String,
  public val finManagerForDept: Department?,
  public val enabled: Boolean,
  public val verified: Boolean
)
