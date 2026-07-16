package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.dto.*;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;



@Service
@RequiredArgsConstructor
public class AdminService {
//    private final AdminRepository adminRepository;
//    private final PasswordEncoder passwordEncoder;
//
//// 관리자 리스트 조회
//    @Transactional(readOnly = true)
//    public List<AdminResponse> listAdmins(int page,int limit) {
//        List<Admin> admins = adminRepository.findAll();
//
//        // 페이징
//        int start = (page - 1 ) * limit;
//        int end = Math.min(start + limit, admins.size());
//
//        List<AdminResponse> responses = new ArrayList<>();
//        for (int i = start; i < end; i++) {
//            responses.add(toResponse(admins.get(i)));
//        }
//        return responses;
//    }
//
//// 관리자 리스트 상세 조회
//    @Transactional(readOnly = true)
//    public AdminResponse getAdminDetail(Long id) {
//        Admin admin = getOrThrow(id);
//        return toResponse(admin);
//    }
//
//
//    //관리자 정보 수정
//    @Transactional
//    public AdminResponse updateInfo(Long id, UpdateAdmin updateAdmin) {
//        Admin admin = getOrThrow(id);
//
//        admin.updateInfo(
//                updateAdmin.getName(),
//                updateAdmin.getEmail(),
//                updateAdmin.getPhonenumber()
//        );
//        adminRepository.save(admin);
//        return toResponse(admin);
//    }
//
//    //관리자 역할 변경
//    @Transactional
//    public AdminResponse changeRole(Long id, String newRole) {
//        Admin admin = getOrThrow(id);
//        admin.changeRole(newRole);
//        adminRepository.save(admin);
//        return toResponse(admin);
//    }
//    //관리자 상태 변경
//    @Transactional
//    public SignupResponse signup(SignupRequest request){
//
//        // 이메일 중복 확인
//        if(adminRepository.findByEmail(request.getEmail()).isPresent()){
//            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
//        }
//
//        admin.changePassword(newPassword);
//        adminRepository.save(admin);
//        return toResponse(admin);
//    }
//    private AdminResponse toResponse(Admin admin){
//        return new AdminResponse(
//                admin.getId(),
//                admin.getName(),
//                admin.getEmail(),
//                admin.getPhonenumber(),
//                admin.getRole(),
//                admin.getStatus(),
//                admin.getCreatedAt(),
//                admin.getApprovedAt(),
//                admin.getRejectedAt(),
//                admin.getRejectionReason()
//        );
//    }
//
//    // 내부 공통 매서드
//    private Admin getOrThrow(Long id) {
//        return adminRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다." + id));
//    }
}
