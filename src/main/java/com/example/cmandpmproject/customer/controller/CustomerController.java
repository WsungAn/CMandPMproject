package com.example.cmandpmproject.customer.controller;

import com.example.cmandpmproject.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CustomerController {
    public CustomerService customerService;
}
