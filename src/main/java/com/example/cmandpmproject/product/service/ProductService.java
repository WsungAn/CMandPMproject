package com.example.cmandpmproject.product.service;

import com.example.cmandpmproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    public ProductRepository productRepository;

}
