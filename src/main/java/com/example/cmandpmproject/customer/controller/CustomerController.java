package com.example.cmandpmproject.customer.controller;

import com.example.cmandpmproject.customer.dto.CustomerResponse;
import com.example.cmandpmproject.customer.dto.CustomerUpdateRequest;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // [고객 리스트 조회]
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        List<CustomerResponse> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    // [고객 상세 조회]
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable String customerId) {
        CustomerResponse customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok(customer);
    }

    // [고객 정보 수정]
    @PutMapping("/{customerId}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable String customerId,
            @Valid @RequestBody CustomerUpdateRequest request
    ) {
        customerService.updateCustomer(customerId, request);
        return ResponseEntity.ok("고객 정보가 성공적으로 수정되었습니다.");
    }

    // [고객 상태 변경]
    @PatchMapping("/{customerId}/status")
    public ResponseEntity<String> updateCustomerStatus(
            @PathVariable String customerId,
            @RequestParam Customer.CustomerStatus status
    ) {
        customerService.updateCustomerStatus(customerId, status);
        return ResponseEntity.ok("고객 상태가 " + status + "(으)로 변경되었습니다.");
    }

    // [고객 삭제]
    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("고객 계정이 성공적으로 삭제(탈퇴) 처리되었습니다.");
    }
}