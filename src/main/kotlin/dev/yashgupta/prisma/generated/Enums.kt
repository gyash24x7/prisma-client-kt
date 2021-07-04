package dev.yashgupta.prisma.generated

import kotlin.String

public enum class Department(
  _name: String
) {
  WEBOPS("Webops"),
  CONCEPT_AND_DESIGN("ConceptAndDesign"),
  SPONSORSHIP_AND_PR("SponsorshipAndPr"),
  FINANCE("Finance"),
  QMS("Qms"),
  OPERATIONS_AND_INFRASTRUCTURE_PLANNING("OperationsAndInfrastructurePlanning"),
  SHOWS_AND_EXHIBITIONS("ShowsAndExhibitions"),
  EVENTS_AND_WORKSHOPS("EventsAndWorkshops"),
  PUBLICITY("Publicity"),
  EVOLVE("Evolve"),
  ENVISAGE("Envisage"),
  ADMIN("Admin"),
}

public enum class UserRole(
  _name: String
) {
  COORDINATOR("Coordinator"),
  HEAD("Head"),
  CORE("Core"),
  COCAS("Cocas"),
  COCAD("Cocad"),
}

public enum class UserScalarFieldEnum(
  _name: String
) {
  ID("id"),
  NAME("name"),
  EMAIL("email"),
  ROLL_NUMBER("rollNumber"),
  DEPARTMENT("department"),
  ROLE("role"),
  PASSWORD("password"),
  SALT("salt"),
  PROFILE_PIC("profilePic"),
  COVER_PIC("coverPic"),
  MOBILE("mobile"),
  UPI("upi"),
  FIN_MANAGER_FOR_DEPT("finManagerForDept"),
  ENABLED("enabled"),
  VERIFIED("verified"),
}

public enum class SortOrder(
  _name: String
) {
  ASC("asc"),
  DESC("desc"),
}

public enum class QueryMode(
  _name: String
) {
  DEFAULT("default"),
  INSENSITIVE("insensitive"),
}
