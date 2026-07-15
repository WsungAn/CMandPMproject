package com.example.cmandpmproject.product.controller;

import com.example.cmandpmproject.admin.service.AdminService;
import com.example.cmandpmproject.product.entity.Product;
import com.example.cmandpmproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {
    public ProductService productService;
}
