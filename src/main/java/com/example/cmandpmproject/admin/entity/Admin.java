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

    @Column(nullable=false)
    private String adminname;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
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
    ){

        this.adminname=getAdminname();
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.role=role;

        // 기본값은 승인대기
        this.status=AdminStatus.PENDING;
    }

}







