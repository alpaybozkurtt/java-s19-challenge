package com.example.workintech.repository;

import com.example.workintech.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p ORDER BY p.likes DESC")
    List<Product> findAllOrderByLikesDesc(); // Ürünleri beğeni sayısına göre azalan sırada getir
}
