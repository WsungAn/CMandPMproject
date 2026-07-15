package com.example.cmandpmproject.admin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateAdminRequest {
    private Long userId;
    private String name;
    private String email;
    private String phonenumber;

    public UpdateAdminRequest(Long userId, String name, String email, String phonenumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }
}