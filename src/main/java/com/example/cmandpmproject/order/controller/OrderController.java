package com.example.cmandpmproject.order.controller;

import com.example.cmandpmproject.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderController {
    public OrderService orderService;
}
