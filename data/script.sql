DROP TABLE IF EXISTS product;
CREATE TABLE product
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(50),
  brand varchar(50),
  maidin varchar(50),
  price float
);