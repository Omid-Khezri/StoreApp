package com.storeapp.repository;
import com.storeapp.model.Shoppingcart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WarenKorbRepository extends JpaRepository<Shoppingcart, Long> {
}
