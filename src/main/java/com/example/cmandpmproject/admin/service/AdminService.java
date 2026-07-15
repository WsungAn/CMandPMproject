package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.dto.LoginRequest;
import com.example.cmandpmproject.admin.dto.LoginResponse;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {
    public AdminRepository adminRepository;

    private final CustomerRepository customerRepository;

    @Transactional
    public SignupResponse signup(SignupRequest request) {

        if (adminRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        Admin admin = new Admin(
                request.getAdminName(),
                request.getEmail(),
                request.getPassword()
        );

        Admin savedCustomer = adminRepository.save(admin);

        return new SignupResponse(

                savedCustomer.getId(),
                savedCustomer.getAdminName()
        );
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        Admin admin= adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(
                admin.getId(),
                admin.getAdminName()
        );
    }



}
