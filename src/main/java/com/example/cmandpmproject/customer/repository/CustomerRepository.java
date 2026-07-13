package com.example.cmandpmproject.customer.repository;

import com.example.cmandpmproject.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
