package com.example.cmandpmproject.admin.dto;

import lombok.Getter;

@Getter
public class AuthSession {

    private final Long id;
    private final String email;
    private final String role;

    public AuthSession(Long id, String email, String role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
}
