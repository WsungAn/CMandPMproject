package com.example.cmandpmproject.product.controller;

import com.example.cmandpmproject.admin.service.AdminService;
import com.example.cmandpmproject.product.dto.ProductCreateRequest;
import com.example.cmandpmproject.product.dto.ProductResponse;
import com.example.cmandpmproject.product.entity.Product;
import com.example.cmandpmproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }

    // 상품 목록 조회
    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    // 상품 상세 조회
    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }
}
