package com.example.cmandpmproject.product.controller;

import com.example.cmandpmproject.product.dto.ProductCreateRequest;
import com.example.cmandpmproject.product.dto.ProductResponse;
import com.example.cmandpmproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }
}