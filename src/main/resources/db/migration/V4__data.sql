-- Account
INSERT INTO account(name, email, password, role )
VALUES('MAX Mustermann','max@gmail.com', 'pass123', 'User');
-- Product

INSERT INTO product(name, price)
VALUES('Apfel', 1.5),('Brot', 2.0);
-- ShoppingCart

INSERT INTO shoppingcart(name)
VALUES('My Shopping Cart');
INSERT INTO shoppingcart_products(shoppingcart_id, product_id)
VALUES (1, 1), (1, 2);

