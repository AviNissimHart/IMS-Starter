INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Avi', 'Nissim');

INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Chocolate', '0.5');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Birthday Cake', '20');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Coca Cola', '0.80');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Scented Candle', '2.50');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Bread', '0.90');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Broom', '4.99');

INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('1');
INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('1');
INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('1');
INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('1');
INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('2');


INSERT INTO `ims`.`orderitems` (`fk_iid`, `fk_oid`) VALUES ('1','2');
INSERT INTO `ims`.`orderitems` (`fk_iid`, `fk_oid`) VALUES ('2','2');
INSERT INTO `ims`.`orderitems` (`fk_iid`, `fk_oid`) VALUES ('5','2');
INSERT INTO `ims`.`orderitems` (`fk_iid`, `fk_oid`) VALUES ('5','2');
