package com.example.cmandpmproject.customer.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String customerName;
    private String email;
    private String password;
}
