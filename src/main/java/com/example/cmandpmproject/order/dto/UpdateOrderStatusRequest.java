package com.example.cmandpmproject.order.dto;

import com.example.cmandpmproject.order.entity.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateOrderStatusRequest {

    private OrderStatus status;

}
