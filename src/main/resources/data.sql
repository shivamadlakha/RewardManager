DROP TABLE IF EXISTS Customer;
  
CREATE TABLE Customer(
  id INT PRIMARY KEY,
  name VARCHAR(150) NOT NULL);

DROP TABLE IF EXISTS Transaction ;
  
CREATE TABLE Transaction (
  id INT PRIMARY KEY,
  amount INT,
creation_date DATE,
  description VARCHAR(150),
 reward_flag VARCHAR(150),
  customer_id INT
);

ALTER TABLE Transaction ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);

Insert into Customer values(1,'Raman');
Insert into Customer values(2,'Shivam');
Insert into Customer values(3,'Sagar');

Insert into Transaction values(5001,110,'2024-09-12','amazon','n',,1);
Insert into Transaction values(5002,60,'2024-08-12','flipkart','n',1);
Insert into Transaction values(5003,30,'2024-09-12','zepto','n',1);

