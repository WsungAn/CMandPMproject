package com.example.cmandpmproject.customer.dto;

import com.example.cmandpmproject.customer.entity.Customer;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CustomerResponse {

    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final String status;
    private final LocalDate createdAt;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.status = customer.getStatus();
        this.createdAt = customer.getCreatedAt();
    }
}