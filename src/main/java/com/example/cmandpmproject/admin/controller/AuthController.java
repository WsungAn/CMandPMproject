package com.example.cmandpmproject.admin.controller;

import com.example.cmandpmproject.admin.dto.AuthLoginRequest;
import com.example.cmandpmproject.admin.dto.AuthSession;
import com.example.cmandpmproject.admin.dto.MessageResponse;
import com.example.cmandpmproject.admin.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        httpSession.setAttribute("adminName", authSession);
        httpSession.setMaxInactiveInterval(12 * 60 * 60);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("정상적으로 로그인이 되었습니다."));
    }

    @PostMapping("/logout")
    public ResponseEntity<MessageResponse> logout(
            @SessionAttribute(name = "adminName", required = false)
            AuthSession authSession,
            HttpSession httpSession
    ) {
        if (authSession == null) {
            return ResponseEntity.badRequest().build();
        }
        httpSession.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("정상적으로 로그아웃이 되었습니다."));
    }

}
