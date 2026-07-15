package com.example.cmandpmproject.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AdminLoginRequest {

    @Email
    private String email;
    @NotBlank
    private String password;
}
