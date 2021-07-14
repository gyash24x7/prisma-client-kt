-- CreateEnum
CREATE TYPE "TaskStatus" AS ENUM ('NotAssigned', 'Assigned', 'InProgress', 'Submitted', 'Completed');

-- CreateEnum
CREATE TYPE "UserRole" AS ENUM ('Coordinator', 'Head', 'Core', 'Cocas', 'Cocad');

-- CreateEnum
CREATE TYPE "Department" AS ENUM ('Webops', 'ConceptAndDesign', 'SponsorshipAndPr', 'Finance', 'Qms', 'OperationsAndInfrastructurePlanning', 'ShowsAndExhibitions', 'EventsAndWorkshops', 'Publicity', 'Evolve', 'Envisage', 'Admin');

-- CreateTable
CREATE TABLE "User" (
    "id" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "rollNumber" TEXT NOT NULL,
    "department" "Department" NOT NULL,
    "role" "UserRole" NOT NULL DEFAULT E'Coordinator',
    "password" TEXT NOT NULL,
    "salt" TEXT NOT NULL,
    "profilePic" TEXT NOT NULL DEFAULT E'',
    "coverPic" TEXT NOT NULL DEFAULT E'',
    "mobile" TEXT NOT NULL,
    "upi" TEXT NOT NULL DEFAULT E'',
    "finManagerForDept" "Department",
    "enabled" BOOLEAN NOT NULL DEFAULT false,
    "verified" BOOLEAN NOT NULL DEFAULT false,

    PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Update" (
    "id" TEXT NOT NULL,
    "brief" TEXT NOT NULL,
    "subject" TEXT NOT NULL,
    "details" TEXT NOT NULL,
    "createdOn" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "createdById" TEXT NOT NULL,
    "byDept" "Department" NOT NULL,

    PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Task" (
    "id" TEXT NOT NULL,
    "brief" TEXT NOT NULL,
    "details" TEXT NOT NULL,
    "deadline" TIMESTAMP(3) NOT NULL,
    "createdOn" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "byDepartment" "Department" NOT NULL,
    "forDepartment" "Department" NOT NULL,
    "createdById" TEXT NOT NULL,
    "status" "TaskStatus" NOT NULL DEFAULT E'NotAssigned',

    PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "__TasksAssignedTo" (
    "A" TEXT NOT NULL,
    "B" TEXT NOT NULL
);

-- CreateIndex
CREATE UNIQUE INDEX "User.email_unique" ON "User"("email");

-- CreateIndex
CREATE UNIQUE INDEX "User.rollNumber_unique" ON "User"("rollNumber");

-- CreateIndex
CREATE UNIQUE INDEX "User.salt_unique" ON "User"("salt");

-- CreateIndex
CREATE UNIQUE INDEX "__TasksAssignedTo_AB_unique" ON "__TasksAssignedTo"("A", "B");

-- CreateIndex
CREATE INDEX "__TasksAssignedTo_B_index" ON "__TasksAssignedTo"("B");

-- AddForeignKey
ALTER TABLE "Update" ADD FOREIGN KEY ("createdById") REFERENCES "User"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Task" ADD FOREIGN KEY ("createdById") REFERENCES "User"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "__TasksAssignedTo" ADD FOREIGN KEY ("A") REFERENCES "Task"("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "__TasksAssignedTo" ADD FOREIGN KEY ("B") REFERENCES "User"("id") ON DELETE CASCADE ON UPDATE CASCADE;
