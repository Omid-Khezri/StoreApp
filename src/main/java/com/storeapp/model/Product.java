package com.storeapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "Preis", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "Bild")
    private String image;

    public Product() {}

    public Product(String name, BigDecimal price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
