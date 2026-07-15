package com.example.cmandpmproject.admin.dto;

import lombok.Getter;

@Getter
public class AdminSession {

    private final Long id;
    private final String email;
    private final String role;

    public AdminSession(Long id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
}
