package com.example.cmandpmproject.order.dto;

import ch.qos.logback.core.status.Status;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.product.entity.Product;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;
import jdk.jshell.Snippet;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateOrderRequest {
    private Long customerId;
    private Long productId;
    private int quantity;
}

