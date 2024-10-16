package com.example.service;

import com.example.model.User;
import com.example.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final Map<String, User> users = new HashMap<>();
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;

        
        users.put("user1@webtech.id", new User("User One", "user1@webtech.id", "password1"));
        users.put("user2@webtech.id", new User("User Two", "user2@webtech.id", "password2"));
    }

    public String authenticate(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return jwtUtil.generateToken(user.getEmail());
        }
        return null;
    }

    public boolean logout(String token) {
        
        
        return jwtUtil.validateToken(token, jwtUtil.extractEmail(token));
    }
}