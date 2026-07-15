package com.example.cmandpmproject.admin.dto;

import lombok.Getter;

@Getter
public class AdminSession {

    private final Long id;
    private final String username;
    private final String email;

    public AdminSession(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
