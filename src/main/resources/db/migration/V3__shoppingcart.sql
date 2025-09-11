CREATE TABLE shoppingcart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE shoppingcart_products (
    shoppingcart_id BIGINT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (shoppingcart_id, product_id),
    FOREIGN KEY (shoppingcart_id) REFERENCES shoppingcart(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
