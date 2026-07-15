package com.example.cmandpmproject.admin.entity;

import com.example.cmandpmproject.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "admins")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String AdminName;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    public Admin(String adminName, String email, String password) {
        this.AdminName = getAdminName();
        this.email = email;
        this.password = password;
    }







    // 필드 + 생성자 설정!!



}

