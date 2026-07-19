package com.example.cmandpmproject.product.controller;

import com.example.cmandpmproject.product.dto.ProductCreateRequest;
import com.example.cmandpmproject.product.dto.ProductResponse;
import com.example.cmandpmproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.cmandpmproject.product.dto.ProductUpdateRequest;
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
    // 상품 수정
    @PutMapping("/{productId}")
    public ProductResponse updateProduct(
            @PathVariable Long productId,
            @RequestBody ProductUpdateRequest request
    ) {
        return productService.updateProduct(productId, request);
    }
    // 상품 삭제
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}