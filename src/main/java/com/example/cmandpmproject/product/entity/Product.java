package com.example.cmandpmproject.product.entity;

import com.example.cmandpmproject.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String category;

    private Integer price;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;



    //필드 + 생성자 설정
    @Builder
    private Product(
            String name,
            String category,
            Integer price,
            Integer stock,
            ProductStatus status
    ) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }



}
