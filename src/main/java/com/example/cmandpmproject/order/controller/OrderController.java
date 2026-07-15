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
    public OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> create(
            @Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(request));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<GetAllOrderResponse>> getOrders(
            @ModelAttribute OrderSearchCondition condition) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders(condition));
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(orderId));
    }

//    @PatchMapping("/orders/{orderId}/status")
//    public ResponseEntity<UpdateOrderResponse> update(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request) {
//        return ResponseEntity.status(HttpStatus.OK).body(orderService.update());
//    }

//    @DeleteMapping("orders/{orderId}")
//    public ResponseEntity<Void> delete(@PathVariable Long orderId, @RequestBody DeleteOrderRequest request) {
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

}
