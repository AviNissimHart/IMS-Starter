INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Avi', 'Nissim');

INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Chocolate', '0.5');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Birthday Cake', '20');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Coca Cola', '0.80');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Scented Candle', '2.50');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Bread', '0.90');
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('Broom', '4.99');

INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('1');
INSERT INTO `ims`.`orders` (`fk_cid`) VALUES ('2');



INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('2','1');
INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('2','2');
INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('2','5');
INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('2','5');
INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('1','5');
INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES ('1','3');


update orders set order_total = (select sum(price) from items, orderitems where iid = orderitems.fk_iid && orderitems.fk_oid = 1) where oid = 1;
update orders set order_total = (select sum(price) from items, orderitems where iid = orderitems.fk_iid && orderitems.fk_oid = 2) where oid = 2;