package com.example.cmandpmproject.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequest {

    private String name;

    private String category;

    private Integer price;

    private Integer stock;
}