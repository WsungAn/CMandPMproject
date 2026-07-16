package com.example.cmandpmproject.admin.controller;

import com.example.cmandpmproject.admin.dto.*;
import com.example.cmandpmproject.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AdminController {
//    private final AdminService adminService;
//
//    // 관리자 리스트 조회
//    @GetMapping
//    public ResponseEntity<List<AdminResponse>> listAdmins(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int limit) {
//        List<AdminResponse> responseList = adminService.listAdmins(page, limit);
//        return ResponseEntity.ok(responseList);
//    }
//
//    // 관리자 리스트 상세 조회
//    @GetMapping("/{id}")
//    public ResponseEntity<AdminResponse> getAdminDetail(@PathVariable Long id) {
//        AdminResponse adminResponse = adminService.getAdminDetail(id);
//        return ResponseEntity.ok(adminResponse);
//    }
//
//    // 관리자 정보 수정
//    @PutMapping("/{id}")
//    public ResponseEntity<AdminResponse> updateInfo(@PathVariable Long id, @RequestBody UpdateAdmin updateAdmin) {
//        AdminResponse adminResponse = adminService.updateInfo(id, updateAdmin);
//        return ResponseEntity.ok(adminResponse);
//    }
//
//    // 관리자 역할 변경
//    @PatchMapping("/{id}/role")
//    public ResponseEntity<AdminResponse> changeRole(@PathVariable Long id, @RequestParam String newRole) {
//        AdminResponse adminResponse = adminService.changeRole(id, newRole);
//        return ResponseEntity.ok(adminResponse);
//    }
//
//
//
//
//    // 내 프로필 수정
//    @PutMapping("/me")
//    public ResponseEntity<AdminResponse> updateMyprofile(@RequestBody UpdateAdminRequest request) {
//        AdminResponse adminResponse = adminService.updateMyprofile(
//                request.getUserId(),
//                new UpdateAdmin(request.getName(), request.getEmail(), request.getPhonenumber())
//        );
//        return ResponseEntity.ok(adminResponse);
//    }
//
//    // 비밀번호 변경
//    @PutMapping("/auth/password")
//    public ResponseEntity<AdminResponse> changePassword(@RequestBody ChangePasswordRequest request) {
//        AdminResponse response = adminService.changePassword(
//                request.getUserId(),
//                request.getOldPassword(),
//                request.getNewPassword()
//        );
//        return ResponseEntity.ok(response);
//    }
}
