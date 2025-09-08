package com.deloitte.UCM.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UCM")
public class UcmController {

    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Server is running successfully!");
    }
}
