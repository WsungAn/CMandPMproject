
package com.example.cmandpmproject.admin.controller;

import com.example.cmandpmproject.admin.dto.LoginRequest;
import com.example.cmandpmproject.admin.dto.LoginResponse;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;
import com.example.cmandpmproject.admin.dto.ChangePasswordRequest;
import com.example.cmandpmproject.admin.dto.AdminResponse;
import com.example.cmandpmproject.admin.dto.UpdateAdmin;
import com.example.cmandpmproject.admin.dto.UpdateAdminRequest;
import com.example.cmandpmproject.admin.entity.Admin;
import com.example.cmandpmproject.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class AdminController {
    public AdminService adminService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request){

        return adminService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return adminService.login(request);
    }

}
    private final AdminService adminService;

    // 관리자 리스트 조회
    @GetMapping
    public ResponseEntity<List<AdminResponse>> listAdmins() {
        List<AdminResponse> responseList = adminService.listAdmins();
        return ResponseEntity.ok(responseList);
    }

    // 관리자 리스트 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdminDetail(@PathVariable Long id) {
        AdminResponse adminResponse = adminService.getAdminDetail(id);
        return ResponseEntity.ok(adminResponse);
    }

    //관리자 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponse> updateInfo(@PathVariable Long id, @RequestBody UpdateAdmin updateAdmin) {
        AdminResponse adminResponse = adminService.updateInfo(id, updateAdmin);
        return ResponseEntity.ok(adminResponse);
    }

    // 관리자 역할 변경
    @PatchMapping("/{id}/role")
    public ResponseEntity<AdminResponse> changeRole(@PathVariable Long id, @RequestParam String newRole) {
        AdminResponse adminResponse = adminService.changeRole(id, newRole);
        return ResponseEntity.ok(adminResponse);
    }

    // 관리자 상태 변경
    @PatchMapping("/{id}/status")
    public ResponseEntity<AdminResponse> changeStatus(@PathVariable Long id, @RequestParam String newStatus) {
        AdminResponse adminResponse = adminService.changeStatus(id, newStatus);
        return ResponseEntity.ok(adminResponse);
    }

    // 관리자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 관리자 승인
    @PatchMapping("/{id}/approval")
    public ResponseEntity<AdminResponse> approveAdmin(@PathVariable Long id) {
        AdminResponse adminResponse = adminService.approveAdmin(id);
        return ResponseEntity.ok(adminResponse);
    }

    // 관리자 거부
    @PatchMapping("/{id}/reject")
    public ResponseEntity<AdminResponse> rejectAdmin(@PathVariable Long id, @RequestParam String reason) {
        AdminResponse adminResponse = adminService.rejectAdmin(id, reason);
        return ResponseEntity.ok(adminResponse);
    }

    // 내 프로필 조회
    @GetMapping("/me")
    public ResponseEntity<AdminResponse> getMyprofile(@RequestParam Long userId) {
        AdminResponse adminResponse = adminService.getMyprofile(userId);
        return ResponseEntity.ok(adminResponse);
    }

    //URL에 {myId} 없음, 로그인된 사용자 ID는 Security Context에서 가져오기????
    //내 프로필 수정
    @PutMapping("/me")
    public ResponseEntity<AdminResponse> updateMyprofile(
            @RequestBody UpdateAdminRequest request) {
        AdminResponse adminResponse = adminService.updateMyprofile(
                request.getUserId(),
                new UpdateAdmin(request.getName(),
                        request.getEmail(),
                        request.getPhonenumber()));
        return ResponseEntity.ok(adminResponse);
    }

    //비밀번호 변경
    @PutMapping("/auth/password")
    public ResponseEntity<AdminResponse> changePassword(@RequestBody ChangePasswordRequest request) {

        AdminResponse response = adminService.changePassword(
                request.getUserId(),
                request.getOldPassword(),
                request.getNewPassword()
        );
        return ResponseEntity.ok(response);
    }




