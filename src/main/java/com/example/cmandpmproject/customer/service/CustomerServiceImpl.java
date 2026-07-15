package com.example.cmandpmproject.customer.service;

import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    // [고객 리스트 조회]
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // [고객 상세 조회]
    @Override
    public Customer getCustomer(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 고객을 찾을 수 없습니다. id: " + id));
    }

    // [고객 정보 수정]
    @Override
    @Transactional
    public void updateCustomer(String id, Customer requestCustomer) {
        Customer customer = getCustomer(id);
        customer.updateInfo(
                requestCustomer.getName(),
                requestCustomer.getEmail(),
                requestCustomer.getPhone()
        );
    }

    // [고객 상태 변경]
    @Override
    @Transactional
    public void updateCustomerStatus(String id, Customer.CustomerStatus status) {
        Customer customer = getCustomer(id);
        customer.updateStatus(status.name());
    }

    // [고객 삭제]
    @Override
    @Transactional
    public void deleteCustomer(String id) {
        Customer customer = getCustomer(id);
        customer.updateStatus("INACTIVE");
    }
}