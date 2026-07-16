package com.example.cmandpmproject.order.dto;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.order.entity.OrderStatus;
import com.example.cmandpmproject.product.entity.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetOrderResponse {
    private final Long id;
    private final String orderNo;
    private final String customerId;
    private final String customerEmail;
    private final Long productId;
    private final Integer quantity;
    private final Integer totalPrice;
    private final LocalDateTime createdAt;
    private final OrderStatus orderStatus;
    private final Long adminId;
    private final String adminEmail;
    private final String adminRole;


    public GetOrderResponse(Long id, String orderNo, String customerId, String customerEmail, Long productId, Integer quantity, Integer totalPrice, LocalDateTime createdAt, OrderStatus orderStatus, Long adminId, String adminEmail, String adminRole) {
        this.id = id;
        this.orderNo = orderNo;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
        this.adminId = adminId;
        this.adminEmail = adminEmail;
        this.adminRole = adminRole;
    }
}

