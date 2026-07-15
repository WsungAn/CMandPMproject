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

    private void validateLoginAdmin(AuthLoginRequest request) {
        if(request.getEmail() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 입력되지 않았습니다.");
        }
        if(request.getEmail().isBlank() || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 입력되지 않았습니다.");
        }
    }

    @Transactional(readOnly = true)
    public AuthSession login(AuthLoginRequest request) {
        validateLoginAdmin(request);

        Admin admin = adminRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("이메일 또는 비밀번호를 잘못 입력하셨습니다.")
        );
        if(!ObjectUtils.nullSafeEquals(admin.getPassword(), request.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 잘못 입력하셨습니다.");
        }
        return new AuthSession(
                admin.getId(),
                admin.getEmail(),
                admin.getRole()
        );

    }
}
