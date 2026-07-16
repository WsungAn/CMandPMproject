package com.example.cmandpmproject.admin.dto;

public enum SortBy {
    NAME("이름"),
    EMAIL("이메일"),
    CREATED_AT("가입일");

    String value;

    SortBy(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
