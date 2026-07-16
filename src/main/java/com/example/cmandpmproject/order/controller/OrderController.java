package com.example.cmandpmproject.order.controller;

import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.order.dto.*;
import com.example.cmandpmproject.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> create(
            @Valid @RequestBody CreateOrderRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.save(request));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<GetAllOrderResponse>> getOrders(
            @ModelAttribute OrderSearchCondition condition
    ) {
        return ResponseEntity.ok(orderService.getOrders(condition));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(
            @PathVariable Long orderId
    ) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    // TODO: 주문 담당자가 UpdateOrderRequest와 상태 변경 Service를 완성한 후 연결
    /*
    @PatchMapping("/orders/{orderId}/status")
    public ResponseEntity<UpdateOrderResponse> update(
            @PathVariable Long orderId,
            @RequestBody UpdateOrderRequest request
    ) {
        return ResponseEntity.ok(orderService.update(orderId, request));
    }
    */

    // TODO: 주문 담당자가 주문 취소 기능을 완성한 후 연결
    /*
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long orderId,
            @RequestBody DeleteOrderRequest request
    ) {
        orderService.delete(orderId, request);
        return ResponseEntity.noContent().build();
    }
    */
}