package com.example.cmandpmproject.admin.entity;

import com.example.cmandpmproject.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "admins")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false, length = 20)
    private String phonenumber;

    @Column(nullable = false, length = 20)
    private String role;

    @Column(nullable = false, length = 20)
    private String status;

    @Column
    private LocalDateTime approvedAt;

    @Column
    private LocalDateTime rejectedAt;

    @Column(length = 150)
    private String rejectionReason;

    // 생성자: 가입 신청 시 사용
    public Admin(String name, String email, String password, String phonenumber, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.role = role;
        this.status = "승인대기";
    }

    // 생성자: 간단한 회원가입 (signup용)
    public Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = "승인대기";
    }

    // 승인
    public void approve() {
        this.status = "활성";
        this.approvedAt = LocalDateTime.now();
    }

    // 거부
    public void reject(String reason) {
        this.status = "거부";
        this.rejectedAt = LocalDateTime.now();
        this.rejectionReason = reason;
    }

    // 상태 변경
    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    // 역할 변경
    public void changeRole(String newRole) {
        this.role = newRole;
    }

    // 정보 수정
    public void updateInfo(String name, String email, String phonenumber) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    // 비밀번호 수정
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // signup/login에서 필요한 메서드
    public String getAdminName() {
        return this.name;
    }
}