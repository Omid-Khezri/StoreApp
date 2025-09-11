package com.storeapp.service;

import com.storeapp.model.Product;
import com.storeapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product p) {
        return repository.save(p);
    }

    public Product updateProduct(int id, Product p) {
        Product existing = repository.findById(id).orElseThrow();
        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        return repository.save(existing);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
}
