CREATE TABLE IF NOT EXISTS organizationtype (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT 'Organization type descriptive name',
  description VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Organization type description',
  ownerId INT(11) NULL DEFAULT NULL,
  departmentId INT(10) UNSIGNED NULL DEFAULT NULL,
  insertDate DATETIME NULL DEFAULT NULL,
  updateDate DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = 'tipos de organizaciones';

CREATE TABLE IF NOT EXISTS organizationisocategory (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT 'ISO Organization Category descriptive name',
  description VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'ISO Organization Category description',
  ownerId INT(11) NULL DEFAULT NULL,
  departmentId INT(10) UNSIGNED NULL DEFAULT NULL,
  insertDate DATETIME NULL DEFAULT NULL,
  updateDate DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = 'tipos de organizaciones segun ISO';


CREATE TABLE IF NOT EXISTS organization (
  id INT(11) NOT NULL AUTO_INCREMENT,
  organizationTypeId INT(11) NOT NULL DEFAULT '1' COMMENT 'organization type id',
  organizationISOCategoryId INT(11) NOT NULL DEFAULT '1' COMMENT 'iso category id',
  name VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  cif VARCHAR(50) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  phone VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  street VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  number VARCHAR(16) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Building number in street',
  locator VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Location information inside building',
  postalCode VARCHAR(32) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  city VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  state VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  country VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  fax VARCHAR(16) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  email VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  website VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  ftpsite VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  notes VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  ownerId INT(11) NULL DEFAULT NULL,
  departmentId INT(10) UNSIGNED NULL DEFAULT NULL,
  insertDate DATETIME NULL DEFAULT NULL,
  updateDate DATETIME NULL DEFAULT NULL,
  evaluationCriteria VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX ndx_organization_organizationTypeId (organizationTypeId ASC),
  INDEX ndx_organization_isoOrganizationCategoryId (organizationISOCategoryId ASC),
  CONSTRAINT fk_organization_isoOrganizationCategoryId
    FOREIGN KEY (organizationISOCategoryId)
    REFERENCES organizationisocategory (id),
  CONSTRAINT fk_organization_organizationTypeId
    FOREIGN KEY (organizationTypeId)
    REFERENCES organizationtype (id))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COMMENT = 'los clientes';



CREATE TABLE IF NOT EXISTS department (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  parentId INT(10) UNSIGNED NULL DEFAULT NULL,
  name VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  description VARCHAR(2048) CHARACTER SET 'utf8' NOT NULL,
  ownerId INT(11) NULL DEFAULT NULL,
  departmentId INT(10) UNSIGNED NULL DEFAULT NULL,
  insertDate DATETIME NULL DEFAULT NULL,
  updateDate DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX ndx_department_department (parentId ASC),
  CONSTRAINT fk_department_department
    FOREIGN KEY (parentId)
    REFERENCES department (id))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS department_organization (
  id INT(11) NOT NULL AUTO_INCREMENT,
  departmentId INT(10) UNSIGNED NOT NULL,
  organizationId INT(11) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_department_organization_department (departmentId ASC),
  INDEX fk_department_organization_organization (organizationId ASC),
  CONSTRAINT fk_department_organization_department
    FOREIGN KEY (departmentId)
    REFERENCES department (id),
  CONSTRAINT fk_department_organization_organization
    FOREIGN KEY (organizationId)
    REFERENCES organization (id))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS contact (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  email VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  phone VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  mobile VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  notified TINYINT(1) NOT NULL DEFAULT '0',
  ownerId INT(11) NULL DEFAULT NULL,
  insertDate DATETIME NULL DEFAULT NULL,
  updateDate DATETIME NULL DEFAULT NULL,
  email2 VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  phone2 VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  fax VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  address VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  postalCode VARCHAR(5) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  city VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  country VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  provinceId INT(11) NULL DEFAULT NULL,
  departmentId INT(10) UNSIGNED NULL DEFAULT NULL,
  active TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS contactinfo (
  id INT(11) NOT NULL AUTO_INCREMENT,
  contactId INT(11) NOT NULL,
  positionId INT(11) NOT NULL,
  departmentId INT(10) UNSIGNED NOT NULL,
  organizationId INT(11) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_contactinfo_contact (contactId ASC),
  INDEX fk_contactinfo_department (departmentId ASC),
  INDEX fk_contactinfo_organization (organizationId ASC),
  CONSTRAINT fk_contactinfo_contact
    FOREIGN KEY (contactId)
    REFERENCES contact (id),
  CONSTRAINT fk_contactinfo_department
    FOREIGN KEY (departmentId)
    REFERENCES department (id),
  CONSTRAINT fk_contactinfo_organization
    FOREIGN KEY (organizationId)
    REFERENCES organization (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



INSERT INTO `OrganizationISOCategory` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (1,'A','Proveedor / Subcontratista habitual.',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationISOCategory` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (2,'B','Proveedor / Subcontratista recomendado.',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationISOCategory` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (3,'C','Proveedor / Subcontratista no habitual.',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationISOCategory` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (4,'D','Proveedor / Subcontratista que haya tenido disconformidades.',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationType` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (1,'Cliente','',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationType` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (2,'Proveedor','',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationType` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (3,'Cliente y proveedor','',NULL,NULL,NULL,NULL);
INSERT INTO `OrganizationType` (`id`,`name`,`description`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (4,'Prospecto','Posible cliente',NULL,NULL,NULL,NULL);

INSERT INTO `Organization` (`id`,`organizationTypeId`,`organizationISOCategoryId`,`name`,`cif`,`phone`,`street`,`number`,`locator`,`postalCode`,`city`,`state`,`country`,`fax`,`email`,`website`,`ftpsite`,`notes`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (1,2,1,'Nuestra empresa',NULL,NULL,NULL,NULL,NULL,NULL,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `Organization` (`id`,`organizationTypeId`,`organizationISOCategoryId`,`name`,`cif`,`phone`,`street`,`number`,`locator`,`postalCode`,`city`,`state`,`country`,`fax`,`email`,`website`,`ftpsite`,`notes`,`ownerId`,`departmentId`,`insertDate`,`updateDate`) VALUES 
  (2,1,1,'Indefinida',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,'2009-04-06 17:20:58','2009-04-06 17:20:58');
  
  INSERT INTO Department (id,name,description) values (1,'Dirección','Departamento de dirección.');
INSERT INTO Department (parentId,name,description) values (1,'I+D+I','Departamento de I+D+I.');
INSERT INTO Department (parentId,name,description) values (1,'Consultoría','Departamento de Consultoría.');

INSERT INTO Department (name, description, ownerId, departmentId, insertDate, updateDate) VALUES ('Indefinido', 'Departamento sin definir', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO Organization (organizationTypeId, organizationISOCategoryId, name,  ownerId, departmentId, insertDate, updateDate) VALUES (1,1, 'Indefinida',  1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into `Department_Organization` (departmentId, organizationId)
(select d.id as department, o.id as organization from Organization o, Department d where d.name = 'Indefinido');
