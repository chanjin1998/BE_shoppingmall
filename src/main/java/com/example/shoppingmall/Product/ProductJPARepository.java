package com.example.shoppingmall.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
//    List<Product> findProducts(int limit, int currentPage);
}
