drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);


USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) NULL DEFAULT NULL,
    `price` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_customer_id` INT(11) NOT NULL,
    `fk_item_id` INT(11) NOT NULL,
    `item_name` VARCHAR(40) NULL DEFAULT NULL,
    `price` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`fk_customer_id`) REFERENCES customers(`id`),
    FOREIGN KEY (`fk_item_id`) REFERENCES items(`id`)
);