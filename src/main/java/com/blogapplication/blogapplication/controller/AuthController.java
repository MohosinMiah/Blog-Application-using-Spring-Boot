package com.blogapplication.blogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.payload.LoginDTO;
import com.blogapplication.blogapplication.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    // Build Login Rest API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> login( @RequestBody LoginDTO loginDTO){

        String response = authService.login(loginDTO);

        return ResponseEntity.ok(response);
    }

}
