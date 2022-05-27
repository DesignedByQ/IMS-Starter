
CREATE TABLE customers(
cust_id INT PRIMARY KEY NOT NULL auto_increment,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL
);

CREATE TABLE items(
item_id INT PRIMARY KEY NOT NULL auto_increment,
price FLOAT(6,2) NOT NULL,
product VARCHAR(50) NOT NULL
);

CREATE TABLE orders(
ord_id INT PRIMARY KEY NOT NULL auto_increment,
total FLOAT(6,2) NOT NULL,
cust_id INT NOT NULL
);

CREATE TABLE pos(
pos_id INT PRIMARY KEY NOT NULL auto_increment,
ord_id INT NOT NULL,
price FLOAT(6,2) NOT NULL,
product VARCHAR(50) NOT NULL
);
