package com.example.cmandpmproject.product.repository;

import com.example.cmandpmproject.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
