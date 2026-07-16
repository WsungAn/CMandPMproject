package com.example.cmandpmproject.customer.dto;

import lombok.Getter;

@Getter
public class CustomerUpdateResponse {

    private final Long id;
    private final String getName;
    private final String getEmail;
    private final String getPhone;

    public CustomerUpdateResponse(Long id, String getName, String getEmail, String getPhone) {
        this.id = id;
        this.getName = getName;
        this.getEmail = getEmail;
        this.getPhone = getPhone;
    }
}
