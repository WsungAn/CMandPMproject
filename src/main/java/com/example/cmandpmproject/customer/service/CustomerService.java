package com.example.cmandpmproject.customer.service;

import com.example.cmandpmproject.customer.dto.CustomerResponse;
import com.example.cmandpmproject.customer.dto.CustomerUpdateRequest;
import com.example.cmandpmproject.customer.entity.Customer;
import java.util.List;

public interface CustomerService {

    // [고객 리스트 조회]
    List<CustomerResponse> getCustomers();

    // [고객 상세 조회]
    CustomerResponse getCustomer(String id);

    // [고객 정보 수정]
    void updateCustomer(String id, CustomerUpdateRequest request);

    // [고객 상태 변경]
    void updateCustomerStatus(String id, Customer.CustomerStatus status);

    // [고객 삭제]
    void deleteCustomer(String id);
}