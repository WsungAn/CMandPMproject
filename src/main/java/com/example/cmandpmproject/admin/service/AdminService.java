package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.Config.PasswordEncoder;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponse signup(SignupRequest request){

        // 이메일 중복 확인
        if(adminRepository.findByEmail(request.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 이메일 형식 검사
        if(!request.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
        }

        // 비밀번호 길이 검사
        if(request.getPassword().length()<8){
            throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
        }

        // 전화번호 형식 검사
        if(!request.getPhone().matches("^010-\\d{4}-\\d{4}$")){
            throw new IllegalArgumentException("전화번호 형식이 올바르지 않습니다.");
        }

        // 이름 검사
        if(request.getAdminName()==null || request.getAdminName().isBlank()){
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        // 역할 검사
        if(request.getRole()==null){
            throw new IllegalArgumentException("역할을 선택하세요.");
        }

        Admin admin = new Admin(

                request.getAdminName(),

                request.getEmail(),

                // 암호화
                passwordEncoder.encode(request.getPassword()),

                request.getPhone(),

                request.getRole()
        );

        Admin savedAdmin = adminRepository.save(admin);

        return new SignupResponse(

                savedAdmin.getId(),

                savedAdmin.getAdminname(),

                savedAdmin.getStatus()
        );

    }

}


