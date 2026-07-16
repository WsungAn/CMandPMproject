package com.example.cmandpmproject.admin.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String phonenumber;
    private final String role;
    private final String status;
    private final LocalDateTime createdAt;
    private final LocalDateTime approvedAt;
    private final LocalDateTime rejectedAt;
    private final String rejectionReason;

    public AdminResponse(Long id, String name, String email, String phonenumber, String role, String status, LocalDateTime createdAt, LocalDateTime approvedAt,LocalDateTime rejectedAt,
                         String rejectionReason) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.approvedAt = approvedAt;
        this.rejectedAt = rejectedAt;
        this.rejectionReason = rejectionReason;
    }
}
