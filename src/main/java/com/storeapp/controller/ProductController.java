package com.storeapp.controller;

import com.storeapp.model.Product;
import com.storeapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST-APIs, , damit du die Daten von außen abrufen oder ändern kannst.

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }


    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.addProduct(p);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product p) {
        return service.updateProduct(id, p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product!=null) {
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();

        }
    }
}
