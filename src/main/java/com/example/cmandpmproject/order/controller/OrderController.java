package com.example.cmandpmproject.order.controller;

import com.example.cmandpmproject.order.dto.*;
import com.example.cmandpmproject.order.entity.OrderStatus;
import com.example.cmandpmproject.order.service.OrderService;
import com.example.cmandpmproject.product.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(
            @Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<GetAllOrderResponse>> getOrders(
            @ModelAttribute OrderSearchCondition condition) {
        return ResponseEntity.ok(orderService.getOrders(condition));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Void> update(
            @PathVariable Long orderId,
            @RequestBody UpdateOrderStatusRequest request) {
        orderService.update(orderId, request.getStatus());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(
            @PathVariable Long orderId,
            @Valid @RequestBody CancelOrderRequest request) {
        orderService.cancelOrder(orderId, request.getCancelReason());
        return ResponseEntity.noContent().build();
    }
}