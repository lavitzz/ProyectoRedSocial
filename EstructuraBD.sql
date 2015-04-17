--------------------------------------------------------
-- Archivo creado  - viernes-marzo-20-2015   
--------------------------------------------------------
DROP TABLE "TAW27"."AMIGO" cascade constraints;
DROP TABLE "TAW27"."GRUPO" cascade constraints;
DROP TABLE "TAW27"."GRUPOUSUARIOS" cascade constraints;
DROP TABLE "TAW27"."POST" cascade constraints;
DROP TABLE "TAW27"."USUARIO" cascade constraints;
--------------------------------------------------------
--  DDL for Table AMIGO
--------------------------------------------------------

  CREATE TABLE "TAW27"."AMIGO" 
   (	"ID_AMIGO" NUMBER(*,0), 
	"ID_USUARIO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Table GRUPO
--------------------------------------------------------

  CREATE TABLE "TAW27"."GRUPO" 
   (	"ID_GRUPO" NUMBER(*,0), 
	"NOMBRE_GRUPO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Table GRUPOUSUARIOS
--------------------------------------------------------

  CREATE TABLE "TAW27"."GRUPOUSUARIOS" 
   (	"ID_GRUPO" NUMBER(*,0), 
	"ID_USUARIO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Table POST
--------------------------------------------------------

  CREATE TABLE "TAW27"."POST" 
   (	"ID_POST" NUMBER(*,0), 
	"TITULO" VARCHAR2(20 BYTE), 
	"FECHA" DATE, 
	"TEXTO" VARCHAR2(300 BYTE), 
	"AUTOR" NUMBER(*,0), 
	"GRUPO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "TAW27"."USUARIO" 
   (	"ID_USUARIO" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(20 BYTE), 
	"APELLIDO" VARCHAR2(30 BYTE), 
	"BLOQUEADO" NUMBER(*,0) DEFAULT 0, 
	"CORREO" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
REM INSERTING into TAW27.AMIGO
SET DEFINE OFF;
REM INSERTING into TAW27.GRUPO
SET DEFINE OFF;
REM INSERTING into TAW27.GRUPOUSUARIOS
SET DEFINE OFF;
REM INSERTING into TAW27.POST
SET DEFINE OFF;
REM INSERTING into TAW27.USUARIO
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index GRUPO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TAW27"."GRUPO_PK" ON "TAW27"."GRUPO" ("ID_GRUPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Index POST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TAW27"."POST_PK" ON "TAW27"."POST" ("ID_POST") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Index AMIGO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TAW27"."AMIGO_PK" ON "TAW27"."AMIGO" ("ID_AMIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Index GRUPOUSUARIOS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TAW27"."GRUPOUSUARIOS_PK" ON "TAW27"."GRUPOUSUARIOS" ("ID_GRUPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  DDL for Index USUARIO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TAW27"."USUARIO_PK" ON "TAW27"."USUARIO" ("ID_USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS" ;
--------------------------------------------------------
--  Constraints for Table GRUPO
--------------------------------------------------------

  ALTER TABLE "TAW27"."GRUPO" ADD CONSTRAINT "GRUPO_PK" PRIMARY KEY ("ID_GRUPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS"  ENABLE;
 
  ALTER TABLE "TAW27"."GRUPO" MODIFY ("ID_GRUPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "TAW27"."USUARIO" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
 
  ALTER TABLE "TAW27"."USUARIO" MODIFY ("CORREO" NOT NULL ENABLE);
 
  ALTER TABLE "TAW27"."USUARIO" MODIFY ("PASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "TAW27"."USUARIO" ADD CONSTRAINT "USUARIO_PK" PRIMARY KEY ("ID_USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "TAW27"."POST" ADD CONSTRAINT "POST_PK" PRIMARY KEY ("ID_POST")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS"  ENABLE;
 
  ALTER TABLE "TAW27"."POST" MODIFY ("ID_POST" NOT NULL ENABLE);
 
  ALTER TABLE "TAW27"."POST" MODIFY ("AUTOR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AMIGO
--------------------------------------------------------

  ALTER TABLE "TAW27"."AMIGO" ADD CONSTRAINT "AMIGO_PK" PRIMARY KEY ("ID_AMIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS"  ENABLE;
 
  ALTER TABLE "TAW27"."AMIGO" MODIFY ("ID_AMIGO" NOT NULL ENABLE);
 
  ALTER TABLE "TAW27"."AMIGO" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPOUSUARIOS
--------------------------------------------------------

  ALTER TABLE "TAW27"."GRUPOUSUARIOS" ADD CONSTRAINT "GRUPOUSUARIOS_PK" PRIMARY KEY ("ID_GRUPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "TS_ALUMNOS"  ENABLE;
 
  ALTER TABLE "TAW27"."GRUPOUSUARIOS" MODIFY ("ID_GRUPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table AMIGO
--------------------------------------------------------

  ALTER TABLE "TAW27"."AMIGO" ADD CONSTRAINT "AMIGO_USUARIO" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "TAW27"."USUARIO" ("ID_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPOUSUARIOS
--------------------------------------------------------

  ALTER TABLE "TAW27"."GRUPOUSUARIOS" ADD CONSTRAINT "GRUPOUSUARIOS_GRUPO" FOREIGN KEY ("ID_GRUPO")
	  REFERENCES "TAW27"."GRUPO" ("ID_GRUPO") ENABLE;
 
  ALTER TABLE "TAW27"."GRUPOUSUARIOS" ADD CONSTRAINT "GRUPOUSUARIOS_USUARIO" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "TAW27"."USUARIO" ("ID_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POST
--------------------------------------------------------

  ALTER TABLE "TAW27"."POST" ADD CONSTRAINT "POST_GRUPO" FOREIGN KEY ("GRUPO")
	  REFERENCES "TAW27"."GRUPO" ("ID_GRUPO") ENABLE;
 
  ALTER TABLE "TAW27"."POST" ADD CONSTRAINT "POST_USUARIO" FOREIGN KEY ("AUTOR")
	  REFERENCES "TAW27"."USUARIO" ("ID_USUARIO") ENABLE;
