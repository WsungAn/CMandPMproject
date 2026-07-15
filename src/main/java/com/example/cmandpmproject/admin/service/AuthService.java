package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.dto.AuthLoginRequest;
import com.example.cmandpmproject.admin.dto.AuthSession;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public AuthSession login(AuthLoginRequest request) {
        Admin admin = adminRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("해당 유저가 없습니다.")
        );
        if(!ObjectUtils.nullSafeEquals(admin.getPassword(), request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        return new AuthSession(
                admin.getId(),
                admin.getEmail(),
                admin.getRole()
        );

    }
}
