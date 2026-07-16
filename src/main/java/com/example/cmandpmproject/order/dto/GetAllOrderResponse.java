package com.example.cmandpmproject.order.dto;

import ch.qos.logback.core.status.Status;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.order.entity.OrderStatus;
import com.example.cmandpmproject.product.entity.Product;
import jdk.jshell.Snippet;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetAllOrderResponse {

    private final Long id;
    private final String customerId;
    private final String customerEmail;
    private final String orderNo;
    private final Long productId;
    private final Integer quantity;
    private final Integer totalPrice;
    private final LocalDateTime createdAt;
    private final OrderStatus status;
    private final Admin admin;

    public GetAllOrderResponse(
            Long id,
            String customerId,
            String customerEmail,
            String orderNo,
            Long productId,
            Integer quantity,
            Integer totalPrice,
            LocalDateTime createdAt,
            OrderStatus status,
            Admin admin
    ) {
        this.id = id;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.orderNo = orderNo;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.status = status;
        this.admin = admin;
    }
}

