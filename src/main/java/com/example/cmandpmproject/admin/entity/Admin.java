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

    @Column(nullable = false)
    private String adminname;


    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private AdminRole role;

    @Enumerated(EnumType.STRING)
    private AdminStatus status;

    public Admin(
            String adminname,
            String email,
            String password,
            String phone,
            AdminRole role
    ) {

        this.adminname = getAdminname();
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;

        // 기본값은 승인대기
        this.status = AdminStatus.PENDING;
    }


    public Admin(String name, String email, String password, String phonenumber,
                 String role, String status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.role = role;
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

    //비밀 번호 수정
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }


}




