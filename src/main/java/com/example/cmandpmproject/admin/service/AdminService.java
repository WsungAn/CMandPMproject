package com.example.cmandpmproject.admin.service;

import com.example.cmandpmproject.admin.dto.LoginRequest;
import com.example.cmandpmproject.admin.dto.LoginResponse;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.dto.AdminResponse;
import com.example.cmandpmproject.admin.dto.UpdateAdmin;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.repository.AdminRepository;
import com.example.cmandpmproject.customer.entity.Customer;
import com.example.cmandpmproject.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

// 관리자 리스트 조회
    @Transactional(readOnly = true)
    public List<AdminResponse> listAdmins() {
        List<AdminResponse> responses = new ArrayList<>();
        List<Admin> admins = adminRepository.findAll();
        for (Admin admin : admins) {
            responses.add(toResponse(admin));
        }
        return responses;
    }

// 관리자 리스트 상세 조회
    @Transactional(readOnly = true)
    public AdminResponse getAdminDetail(Long id) {
        Admin admin = getOrThrow(id);
        return toResponse(admin);
    }


    //관리자 정보 수정
    @Transactional
    public AdminResponse updateInfo(Long id, UpdateAdmin updateAdmin) {
        Admin admin = getOrThrow(id);

        admin.updateInfo(
                updateAdmin.getName(),
                updateAdmin.getEmail(),
                updateAdmin.getPhonenumber()
        );
        adminRepository.save(admin);
        return toResponse(admin);
    }

    //관리자 역할 변경
    @Transactional
    public AdminResponse changeRole(Long id, String newRole) {
        Admin admin = getOrThrow(id);
        admin.changeRole(newRole);
        adminRepository.save(admin);
        return toResponse(admin);
    }
    //관리자 상태 변경
    @Transactional
    public AdminResponse changeStatus(Long id, String newStatus){
        Admin admin = getOrThrow(id);
        admin.changeStatus(newStatus);
        adminRepository.save(admin);
      return toResponse(admin);
    }
    // 관리자 삭제
    @Transactional
    public void delete(Long id){
        Admin admin = getOrThrow(id);
        adminRepository.delete(admin);
    }
    //관리자 승인
    @Transactional
    public AdminResponse approveAdmin(Long id){
        Admin admin = getOrThrow(id);
        admin.approve();
        adminRepository.save(admin);
        return toResponse(admin);
    }
    //관리자 거부
    @Transactional
    public AdminResponse rejectAdmin(Long id, String reason){
        Admin admin = getOrThrow(id);
        admin.reject(reason);
        adminRepository.save(admin);

        return toResponse(admin);
    }

    // 내 프로필 조회 ????????????????
    @Transactional
    public AdminResponse getMyprofile(Long myId){
        return getAdminDetail(myId);
    }

    // 내 프로필 수정
    @Transactional
    public AdminResponse updateMyprofile(Long myId, UpdateAdmin updateAdmin){
        return updateInfo(myId, updateAdmin);
    }


    // 비밀번호 변경
    @Transactional
    public AdminResponse changePassword(Long id, String oldPassword, String newPassword){
        Admin admin = getOrThrow(id);

        //변경 전 비밀번호가 같지 않으면 변경 불가
        if(!admin.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");

        }

        admin.changePassword(newPassword);
        adminRepository.save(admin);
        return toResponse(admin);
    }
    private AdminResponse toResponse(Admin admin){
        return new AdminResponse(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                admin.getPhonenumber(),
                admin.getRole(),
                admin.getStatus(),
                admin.getCreatedAt(),
                admin.getApprovedAt(),
                admin.getRejectedAt(),
                admin.getRejectionReason()
        );
    }

    // 내부 공통 매서드
    private Admin getOrThrow(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다." + id));
    }






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
