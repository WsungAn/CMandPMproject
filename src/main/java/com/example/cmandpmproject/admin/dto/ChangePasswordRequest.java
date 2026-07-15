package com.example.cmandpmproject.admin.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangePasswordRequest {
    private Long userId;
    private String oldPassword;
    private String newPassword;

    public ChangePasswordRequest(Long userId, String oldPassword, String newPassword) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}