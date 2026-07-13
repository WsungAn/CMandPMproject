package com.example.cmandpmproject.customer.service;

import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    public CustomerRepository customerRepository;
}
