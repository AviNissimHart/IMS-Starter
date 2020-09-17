drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `cid` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`cid`)
);


USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `iid` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) NULL DEFAULT NULL,
    `price` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`iid`)
);

USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `oid` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_cid` INT(11) NOT NULL,
    `order_total` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`oid`),
    CONSTRAINT FOREIGN KEY (`fk_cid`) REFERENCES customers(`cid`)  ON DELETE CASCADE
);

USE `ims`;
CREATE TABLE IF NOT EXISTS `ims`.`orderItems` (
    `oiid` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_oid` INT(11) NOT NULL,
    `fk_iid` INT(11) NOT NULL,
    PRIMARY KEY (`oiid`),
    CONSTRAINT FOREIGN KEY (`fk_oid`) REFERENCES orders(`oid`) ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (`fk_iid`) REFERENCES items(`iid`) ON DELETE CASCADE
);
