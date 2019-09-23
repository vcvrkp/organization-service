CREATE TABLE IF NOT EXISTS `organizationtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT 'Organization type descriptive name',
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Organization type description',
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = 'tipos de organizaciones';

CREATE TABLE IF NOT EXISTS `organizationisocategory` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT 'ISO Organization Category descriptive name',
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'ISO Organization Category description',
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = 'tipos de organizaciones segun ISO';


CREATE TABLE IF NOT EXISTS `organization` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `organizationTypeId` INT(11) NOT NULL DEFAULT '1' COMMENT 'organization type id',
  `organizationISOCategoryId` INT(11) NOT NULL DEFAULT '1' COMMENT 'iso category id',
  `name` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `cif` VARCHAR(50) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `phone` VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `street` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `number` VARCHAR(16) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Building number in street',
  `locator` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'Location information inside building',
  `postalCode` VARCHAR(32) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `city` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `state` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `country` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `fax` VARCHAR(16) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `email` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `website` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `ftpsite` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `notes` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  `evaluationCriteria` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `ndx_organization_organizationTypeId` (`organizationTypeId` ASC),
  INDEX `ndx_organization_isoOrganizationCategoryId` (`organizationISOCategoryId` ASC),
  CONSTRAINT `fk_organization_isoOrganizationCategoryId`
    FOREIGN KEY (`organizationISOCategoryId`)
    REFERENCES `organizationisocategory` (`id`),
  CONSTRAINT `fk_organization_organizationTypeId`
    FOREIGN KEY (`organizationTypeId`)
    REFERENCES `organizationtype` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COMMENT = 'los clientes';

CREATE TABLE IF NOT EXISTS `department` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `name` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `description` VARCHAR(2048) CHARACTER SET 'utf8' NOT NULL,
  `ownerId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  `organizationId` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ndx_department_department` (`parentId` ASC),
  INDEX `ndx_department_orgid` (`organizationId` ASC),
  CONSTRAINT `fk_department_department`
    FOREIGN KEY (`parentId`)
    REFERENCES `department` (`id`),
	CONSTRAINT `fk_department_organization`
    FOREIGN KEY (`organizationId`)
    REFERENCES `organization` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `contact` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `phone` VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `mobile` VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `notified` TINYINT(1) NOT NULL DEFAULT '0',
  `ownerId` INT(11) NULL DEFAULT NULL,
  `insertDate` DATETIME NULL DEFAULT NULL,
  `updateDate` DATETIME NULL DEFAULT NULL,
  `email2` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `phone2` VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `fax` VARCHAR(15) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `address` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `postalCode` VARCHAR(5) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `city` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `country` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `provinceId` INT(11) NULL DEFAULT NULL,
  `departmentId` INT(10) UNSIGNED NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `ndx_contact_department` (`departmentId` ASC),
  CONSTRAINT `fk_contact_department`
    FOREIGN KEY (`departmentId`)
    REFERENCES `department` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'contactos de las Organizationes';


