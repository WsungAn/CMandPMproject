package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.Config.PasswordEncoder;
import com.example.cmandpmproject.admin.dto.AuthLoginRequest;
import com.example.cmandpmproject.admin.dto.AuthSession;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    private void validateLoginAdmin(AuthLoginRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 입력되지 않았습니다.");
        }
        if (request.getEmail().isBlank() || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 입력되지 않았습니다.");
        }
    }

    @Transactional(readOnly = true)
    public AuthSession login(AuthLoginRequest request) {
        validateLoginAdmin(request);

        Admin admin = adminRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("이메일 또는 비밀번호를 잘못 입력하셨습니다.")
        );

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 잘못 입력하셨습니다.");
        }

        switch (admin.getStatus()) {
            case ACTIVE:
                break;
            case PENDING:
                throw new IllegalStateException("계정이 승인 대기 상태입니다.");
            case REJECTED:
                throw new IllegalStateException("계정 신청이 거부되었습니다.");
            case SUSPENDED:
                throw new IllegalStateException("계정이 정지되었습니다.");
            case INACTIVE:
                throw new IllegalStateException("계정이 비활성화되었습니다.");
        }
        return new AuthSession(
                admin.getId(),
                admin.getEmail(),
                admin.getRole().getValue()
        );

    }
}