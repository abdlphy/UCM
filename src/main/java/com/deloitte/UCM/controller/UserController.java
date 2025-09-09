package com.deloitte.UCM.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public String getProfile() {
        return "Welcome! You have access to this protected API.";
    }
}
