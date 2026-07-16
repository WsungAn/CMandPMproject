
package com.example.cmandpmproject.admin.controller;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;

import com.example.cmandpmproject.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;




@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {


    private final AdminService adminService;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {

        return adminService.signup(request);
    }
}

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        return adminService.login(request);
    }


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
}




