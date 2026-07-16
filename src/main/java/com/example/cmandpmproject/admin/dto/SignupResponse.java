package com.example.cmandpmproject.admin.dto;

import com.example.cmandpmproject.admin.entity.AdminStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponse {


    private Long id;
    private String adminName;
    private AdminStatus status;

}