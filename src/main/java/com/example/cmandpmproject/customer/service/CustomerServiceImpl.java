package com.example.cmandpmproject.customer.service;

import com.example.cmandpmproject.customer.dto.CustomerResponse;
import com.example.cmandpmproject.customer.dto.CustomerUpdateRequest;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // 고객 리스트 조회
    @Override
    public List<CustomerResponse> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    // 고객 상세 조회
    @Override
    public CustomerResponse getCustomer(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "해당 ID의 고객을 찾을 수 없습니다. id: " + id
                        )
                );

        return new CustomerResponse(customer);
    }

    // 고객 정보 수정
    @Override
    @Transactional
    public void updateCustomer(
            String id,
            CustomerUpdateRequest request
    ) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "해당 ID의 고객을 찾을 수 없습니다. id: " + id
                        )
                );

        customer.updateInfo(
                request.getName(),
                request.getEmail(),
                request.getPhone()
        );
    }

    // 고객 상태 변경
    @Override
    @Transactional
    public void updateCustomerStatus(
            String id,
            Customer.CustomerStatus status
    ) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "해당 ID의 고객을 찾을 수 없습니다. id: " + id
                        )
                );

        customer.updateStatus(status.name());
    }

    // 고객 삭제: 비활성 상태로 변경
    @Override
    @Transactional
    public void deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "해당 ID의 고객을 찾을 수 없습니다. id: " + id
                        )
                );

        customer.updateStatus(Customer.CustomerStatus.INACTIVE.name());
    }
}