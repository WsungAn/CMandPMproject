package com.example.cmandpmproject.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class ProductCreateRequest {

    private String name;

    private String category;

    private Integer price;

    private Integer stock;

}
