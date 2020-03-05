DROP TABLE IF EXISTS products;

CREATE TABLE products (
 id INT AUTO_INCREMENT PRIMARY KEY,
 product_name VARCHAR(100) NOT NULL,
 price DOUBLE(10),
 category VARCHAR(100) DEFAULT NULL,
 availability VARCHAR(100) DEFAULT NULL
 );

INSERT INTO products (product_name, price, category, availability) VALUES
('TV', 25000.00, 'Electronic Appliances', 'IN_STOCK'),
('Fridge', 20000.00, 'Electronic Appliances', 'IN_STOCK'),
('Wi-Fi Modem', 3000.00, 'Digital Communication', 'OUT_OF_STOCK'),
('Air Conditioner', 30000.00, 'Electronic Appliances', 'IN_STOCK');