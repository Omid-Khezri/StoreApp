package com.storeapp.repository;

import com.storeapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Kein extra findById nötig, JpaRepository bringt es schon mit
}

