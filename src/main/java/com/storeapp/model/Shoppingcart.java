package com.storeapp.model;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "shoppingcart")
public class Shoppingcart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "shoppingcart_products",
            joinColumns = @JoinColumn(name = "shoppingcart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


    public Shoppingcart(){}
    public Shoppingcart(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
}
public void setName(String name){
        this.name=name;
}
public List <Product> getProducts(){
        return products;
}

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
