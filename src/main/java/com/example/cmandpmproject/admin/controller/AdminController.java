
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
    public SignupResponse signup(@RequestBody SignupRequest request){

        return adminService.signup(request);
    }
}









