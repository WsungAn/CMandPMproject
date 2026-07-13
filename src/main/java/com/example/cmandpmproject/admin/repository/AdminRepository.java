package com.example.cmandpmproject.admin.repository;

import com.example.cmandpmproject.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
