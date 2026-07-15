package com.example.cmandpmproject.order.dto;

import com.example.cmandpmproject.order.entity.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateOrderResponse {
    private final Long id;
    private final Long productId;
    private final Long customerId;
    private final Long adminId;
    private final int quantity;
    private final int totalPrice;
    private final String orderNo;
    private final OrderStatus orderStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateOrderResponse(Long id, Long productId, Long customerId, Long adminId, int quantity, int totalPrice, String orderNo, OrderStatus orderStatus, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.productId = productId;
        this.customerId = customerId;
        this.adminId = adminId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderNo = orderNo;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}



