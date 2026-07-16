package com.example.cmandpmproject.admin.dto;

import com.example.cmandpmproject.admin.entity.AdminRole;
import lombok.Getter;

@Getter
public class SignupRequest {

    private String adminName;
    private String email;
    private String password;
    private String phone;
    private AdminRole role;
}
