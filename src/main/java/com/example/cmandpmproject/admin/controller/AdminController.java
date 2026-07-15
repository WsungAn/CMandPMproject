package com.example.cmandpmproject.admin.controller;

import com.example.cmandpmproject.admin.dto.LoginRequest;
import com.example.cmandpmproject.admin.dto.LoginResponse;
import com.example.cmandpmproject.admin.dto.SignupRequest;
import com.example.cmandpmproject.admin.dto.SignupResponse;
import com.example.cmandpmproject.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
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
