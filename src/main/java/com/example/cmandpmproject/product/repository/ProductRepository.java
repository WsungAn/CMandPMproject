package com.example.cmandpmproject.product.repository;

import com.example.cmandpmproject.product.entity.Product;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
