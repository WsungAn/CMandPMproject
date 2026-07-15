package com.example.cmandpmproject.admin.dto;

import lombok.Getter;

@Getter
public class UpdateAdmin {
    private Long userId;
    private String name;
    private String email;
    private String phonenumber;


    public UpdateAdmin(String name, String email, String phonenumber) {

        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }
}


