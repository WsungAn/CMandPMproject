package com.example.cmandpmproject.admin.controller;

import com.example.cmandpmproject.admin.dto.AuthLoginRequest;
import com.example.cmandpmproject.admin.dto.AuthSession;
import com.example.cmandpmproject.admin.dto.MessageResponse;
import com.example.cmandpmproject.admin.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<MessageResponse> login(
            @RequestBody AuthLoginRequest request,
            HttpSession httpSession
    ) {
        AuthSession authSession = authService.login(request);
        httpSession.setAttribute("login", authSession);
        httpSession.setMaxInactiveInterval(12 * 60 * 60);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("로그인에 성공!"));
    }

}
