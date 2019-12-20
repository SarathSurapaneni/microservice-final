DROP TABLE IF EXISTS ITEM;
 
CREATE TABLE ITEM (
  id BIGINT(20) NOT NULL auto_increment,
  name varchar(500) NOT NULL,
  description varchar(2000) NOT NULL,
  price BIGINT(20) NOT NULL,
  PRIMARY KEY  (id)
);

