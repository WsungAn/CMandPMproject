package com.example.cmandpmproject.admin.entity;

public enum AdminStatus {

    ACTIVE("활성"),
    INACTIVE("비활성"),
    SUSPENDED("정지"),
    PENDING("승인대기"),
    REJECTED("거부");

    String value;

    AdminStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}