package com.example.controller;

import com.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");
        String token = authService.authenticate(email, password);

        if (token != null) {
            return ResponseEntity.ok(Map.of("message", "Login success", "token", token));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Email atau password salah"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        if (authService.logout(token)) {
            return ResponseEntity.ok(Map.of("message", "Logout sukses"));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Token tidak valid"));
        }
    }
}