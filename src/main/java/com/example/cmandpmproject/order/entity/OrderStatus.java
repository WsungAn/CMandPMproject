package com.example.cmandpmproject.order.entity;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PREPARING("준비중"),
    SHIPPING("배송중"),
    DELIVERED("배송완료"),
    CANCELED("취소됨");

    String value;

    OrderStatus(String value){
        this.value = value;
    }

}
