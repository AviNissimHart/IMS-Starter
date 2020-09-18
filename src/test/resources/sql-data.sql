INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');


INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('jordans', 200);

INSERT INTO `ims`.`orders` (`fk_cid`, `order_total`) VALUES (2, 200);

INSERT INTO `ims`.`orderitems` (`fk_oid`, `fk_iid`) VALUES (1, 1);