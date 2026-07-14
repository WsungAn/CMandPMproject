package com.example.cmandpmproject.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponse {

    private String customerName;
    private Long id;
}