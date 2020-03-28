CREATE DATABASE order_db charset utf8mb4;
CREATE DATABASE product_db charset utf8mb4;

-- 订单表
DROP TABLE
IF
	EXISTS order_db.t_order_info;

CREATE TABLE order_db.t_order_info (
	id BIGINT ( 20 ) PRIMARY KEY auto_increment,
	order_no VARCHAR(64) NOT NULL,
	product_code VARCHAR ( 64 ) NOT NULL,
	price NUMERIC ( 10, 2 ) DEFAULT 0,
	create_time datetime DEFAULT CURRENT_TIMESTAMP ,
	unique uidx_order_no(`order_no`)
) ENGINE = INNODB auto_increment = 1 COMMENT '订单表';

-- 产品表

DROP TABLE
IF
	EXISTS product_db.t_product_info;

CREATE TABLE product_db.t_product_info (
	id BIGINT ( 20 ) auto_increment PRIMARY KEY,
	product_code VARCHAR ( 64 ) NOT NULL,
	product_name VARCHAR ( 128 ) NOT NULL,
	price NUMERIC ( 10, 2 ) DEFAULT 0,
	stock INT ( 6 ) DEFAULT 0,
	create_time datetime DEFAULT CURRENT_TIMESTAMP,
UNIQUE uidx_product_code ( `product_code` )
) ENGINE = INNODB auto_increment = 1 COMMENT '产品表';


INSERT INTO product_db.t_product_info ( product_code, product_name, price, stock ) VALUES( 'P202003281100', 'pc', '5400.00', '50' );
INSERT INTO order_db.t_order_info ( order_no, product_code, price ) VALUES( 'O202003281100', 'P202003281100', '4800' );
