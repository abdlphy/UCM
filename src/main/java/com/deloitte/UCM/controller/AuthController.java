package com.deloitte.UCM.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.deloitte.UCM.DTO.LoginRequest;
import com.deloitte.UCM.config.JwtTokenProvider;
import com.deloitte.UCM.models.User;
import com.deloitte.UCM.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // ✅ BCrypt injected here

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        return userRepository.findByEmail(loginRequest.getEmail())
                .map(user -> {
                 
                    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

                        String token = jwtTokenProvider.generateToken(user.getEmail());

                        // ✅ Return token in JSON format
                        return ResponseEntity.ok().body(
                                "{ \"token\": \"Bearer " + token + "\" }"
                        );
                    } else {
                        return ResponseEntity.status(401).body("Invalid password");
                    }
                })
                .orElse(ResponseEntity.status(404).body("User not found"));
    }
}

