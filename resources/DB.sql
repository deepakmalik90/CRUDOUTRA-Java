--------------------------------------------------------
--  File created - Wednesday-September-23-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTH
--------------------------------------------------------

  CREATE TABLE "AUTH" ("ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , "USER_ID" NUMBER, "TOKEN" VARCHAR2(255), "CREATED_AT" TIMESTAMP (6) DEFAULT SYSTIMESTAMP)
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" ("ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , "USERNAME" VARCHAR2(255), "PASSWORD" VARCHAR2(255))
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("ID")
--------------------------------------------------------
--  DDL for Index auth_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "auth_PK" ON "AUTH" ("ID")
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID") USING INDEX  ENABLE
  ALTER TABLE "USERS" MODIFY ("ID" NOT NULL ENABLE)
  ALTER TABLE "USERS" MODIFY ("USERNAME" NOT NULL ENABLE)
  ALTER TABLE "USERS" MODIFY ("PASSWORD" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table AUTH
--------------------------------------------------------

  ALTER TABLE "AUTH" MODIFY ("ID" NOT NULL ENABLE)
  ALTER TABLE "AUTH" MODIFY ("USER_ID" NOT NULL ENABLE)
  ALTER TABLE "AUTH" MODIFY ("TOKEN" NOT NULL ENABLE)
  ALTER TABLE "AUTH" MODIFY ("CREATED_AT" NOT NULL ENABLE)
  ALTER TABLE "AUTH" ADD CONSTRAINT "auth_PK" PRIMARY KEY ("ID") USING INDEX  ENABLE
--------------------------------------------------------
--  Ref Constraints for Table AUTH
--------------------------------------------------------

  ALTER TABLE "AUTH" ADD CONSTRAINT "USER_ID" FOREIGN KEY ("USER_ID") REFERENCES "USERS" ("ID") ENABLE
