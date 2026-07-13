package com.example.cmandpmproject.order.service;

import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import com.example.cmandpmproject.order.repository.OrderRepository;
import com.example.cmandpmproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    public OrderRepository orderRepository;
    public CustomerRepository customerRepository;
    public AdminRepository adminRepository;
    public ProductRepository productRepository;


}
