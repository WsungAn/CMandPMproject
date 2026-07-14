package com.example.cmandpmproject.customer.controller;

import com.example.cmandpmproject.customer.dto.LoginRequest;
import com.example.cmandpmproject.customer.dto.LoginResponse;
import com.example.cmandpmproject.customer.dto.SignupRequest;
import com.example.cmandpmproject.customer.dto.SignupResponse;
import com.example.cmandpmproject.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request){

        return customerService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return customerService.login(request);
    }
}
