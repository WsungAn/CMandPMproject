package com.example.cmandpmproject.admin.entity;

public enum AdminRole {
    SUPER_ADMIN("슈퍼 관리자"),
    OPERATION_ADMIN("운영 관리자"),
    CS_ADMIN("CS 관리자");

    String value;

    AdminRole(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
