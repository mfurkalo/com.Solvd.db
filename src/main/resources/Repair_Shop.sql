-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Computer_Repair
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Computer_Repair
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Computer_Repair` DEFAULT CHARACTER SET utf8 ;
USE `Computer_Repair` ;

-- -----------------------------------------------------
-- Table `Computer_Repair`.`User_groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`User_groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `allow_add` INT(1) NOT NULL,
  `allow_edit` INT(1) NOT NULL,
  `allow_delate` INT(1) NOT NULL,
  `allow_print` INT(1) NOT NULL,
  `allow_import` INT(1) NOT NULL,
  `allow_export` INT(1) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `fullname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `status` INT(1) NOT NULL,
  `group_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Users_User_groups1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_User_groups1`
    FOREIGN KEY (`group_id`)
    REFERENCES `Computer_Repair`.`User_groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Services` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `amount` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Item_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Item_categories` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(50) NOT NULL,
  `serial_no` VARCHAR(30) NOT NULL,
  `amount` FLOAT NOT NULL,
  `item_category` INT(11) NOT NULL,
  `encoded_by` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Items_Item_Ccategories1_idx` (`item_category` ASC) VISIBLE,
  INDEX `fk_Items_Users1_idx` (`encoded_by` ASC) VISIBLE,
  CONSTRAINT `fk_Items_Item_Ccategories1`
    FOREIGN KEY (`item_category`)
    REFERENCES `Computer_Repair`.`Item_categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Items_Users1`
    FOREIGN KEY (`encoded_by`)
    REFERENCES `Computer_Repair`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Workorders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Workorders` (
  `id` INT(11) NOT NULL,
  `request_date` DATE NOT NULL,
  `amount` FLOAT NOT NULL,
  `estimate_date` DATE NOT NULL,
  `status` INT(1) NOT NULL,
  `remarks` VARCHAR(100) NULL,
  `service_id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `technisian_id` INT(11) NOT NULL,
  `processed_by` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Workorders_Services_idx` (`service_id` ASC) VISIBLE,
  INDEX `fk_Workorders_Users1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_Workorders_Users2_idx` (`technisian_id` ASC) VISIBLE,
  INDEX `fk_Workorders_Users3_idx` (`processed_by` ASC) VISIBLE,
  CONSTRAINT `fk_Workorders_Services`
    FOREIGN KEY (`service_id`)
    REFERENCES `Computer_Repair`.`Services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workorders_Users1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `Computer_Repair`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workorders_Users2`
    FOREIGN KEY (`technisian_id`)
    REFERENCES `Computer_Repair`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workorders_Users3`
    FOREIGN KEY (`processed_by`)
    REFERENCES `Computer_Repair`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Workorderdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Workorderdetails` (
  `id` INT(11) NOT NULL,
  `quantity` INT(5) NOT NULL,
  `amount` FLOAT NOT NULL,
  `total` FLOAT NOT NULL,
  `workorder_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Workorderdetails_Workorders1_idx` (`workorder_id` ASC) VISIBLE,
  INDEX `fk_Workorderdetails_Items1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_Workorderdetails_Workorders1`
    FOREIGN KEY (`workorder_id`)
    REFERENCES `Computer_Repair`.`Workorders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Workorderdetails_Items1`
    FOREIGN KEY (`item_id`)
    REFERENCES `Computer_Repair`.`Items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Computer_Repair`.`Payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computer_Repair`.`Payments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `receipt_no` VARCHAR(15) NOT NULL,
  `total_amount` FLOAT NOT NULL,
  `is_paid` INT(1) NOT NULL,
  `date` DATE NOT NULL,
  `paid_by` VARCHAR(50) NOT NULL,
  `remarks` VARCHAR(50) NULL,
  `workorder_id` INT(11) NOT NULL,
  `processed_by` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Payments_Workorders1_idx` (`workorder_id` ASC) VISIBLE,
  INDEX `fk_Payments_Users1_idx` (`processed_by` ASC) VISIBLE,
  CONSTRAINT `fk_Payments_Workorders1`
    FOREIGN KEY (`workorder_id`)
    REFERENCES `Computer_Repair`.`Workorders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payments_Users1`
    FOREIGN KEY (`processed_by`)
    REFERENCES `Computer_Repair`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
