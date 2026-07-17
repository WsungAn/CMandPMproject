package com.example.cmandpmproject.order.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CancelOrderRequest {
    @NotBlank(message = "취소 사유를 입력해주세요.")
    private String cancelReason;

}
