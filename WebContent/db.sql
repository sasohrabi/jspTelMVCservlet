create DATABASE telApp;

use telApp;

CREATE TABLE tel (
  telId int(5) NOT NULL AUTO_INCREMENT,
  firstName varchar(25) DEFAULT NULL,
  lastName varchar(25) DEFAULT NULL,
  address varchar(15) DEFAULT NULL,
  numtel int(2) DEFAULT NULL,
 PRIMARY KEY (telId));
