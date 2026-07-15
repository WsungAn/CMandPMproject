package com.example.cmandpmproject.product.dto;

import com.example.cmandpmproject.product.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private String name;

    private String category;

    private Integer price;

    private Integer stock;

    private ProductStatus status;
}