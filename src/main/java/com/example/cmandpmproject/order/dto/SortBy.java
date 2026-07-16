package com.example.cmandpmproject.order.dto;

public enum SortBy {
    QUANTITY("수량"),
    PRICE("금액"),
    DATE("주문일");

    String value;

    SortBy(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
