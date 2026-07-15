package com.example.cmandpmproject.admin.repository;

import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long> {

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}

