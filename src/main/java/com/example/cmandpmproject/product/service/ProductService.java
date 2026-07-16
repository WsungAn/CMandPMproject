package com.example.cmandpmproject.product.service;

import com.example.cmandpmproject.product.dto.ProductCreateRequest;
import com.example.cmandpmproject.product.dto.ProductResponse;
import com.example.cmandpmproject.product.entity.Product;
import com.example.cmandpmproject.product.entity.ProductStatus;
import com.example.cmandpmproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 등록
    public ProductResponse createProduct(ProductCreateRequest request) {

        Product product = Product.builder()
                .name(request.getName())
                .category(request.getCategory())
                .price(request.getPrice())
                .stock(request.getStock())
                .status(ProductStatus.SALE)
                .build();

        productRepository.save(product);

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getStatus()
        );
    }

    // 상품 목록 조회
    public List<ProductResponse> getProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getStock(),
                        product.getStatus()
                ))
                .toList();
    }

    // 상품 상세 조회
    public ProductResponse getProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock(),
                product.getStatus()
        );
    }
}