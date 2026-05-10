CREATE TABLE t_orders (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    order_no VARCHAR(255) DEFAULT NULL,
    sku_code VARCHAR(255),
    total_price decimal(19,2),
    quantity int(11),
    PRIMARY KEY (id)
)