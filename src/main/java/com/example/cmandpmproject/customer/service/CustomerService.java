package com.example.cmandpmproject.customer.service;

import com.example.cmandpmproject.customer.dto.LoginRequest;
import com.example.cmandpmproject.customer.dto.LoginResponse;
import com.example.cmandpmproject.customer.dto.SignupRequest;
import com.example.cmandpmproject.customer.dto.SignupResponse;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public SignupResponse signup(SignupRequest request) {

        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        Customer customer = new Customer(
                request.getCustomerName(),
                request.getEmail(),
                request.getPassword()
        );

        Customer savedCustomer = customerRepository.save(customer);

        return new SignupResponse(
                savedCustomer.getCustomerName(),
                savedCustomer.getId()
        );
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!customer.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(
                customer.getId(),
                customer.getCustomerName()
        );
    }


}
