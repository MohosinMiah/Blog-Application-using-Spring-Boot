package com.blogapplication.blogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.blogapplication.payload.JWTAuthResponse;
import com.blogapplication.blogapplication.payload.LoginDTO;
import com.blogapplication.blogapplication.payload.RegisterDTO;
import com.blogapplication.blogapplication.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    // Build Login Rest API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login( @RequestBody LoginDTO loginDTO){

        String token = authService.login(loginDTO);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        
        jwtAuthResponse.setAccessToken(token);


        return ResponseEntity.ok(jwtAuthResponse);
    }

        // Build Register  Rest API
        @PostMapping(value = {"/register", "/signup"})
        public ResponseEntity<String> register( @RequestBody RegisterDTO registerDTO){
    
            String response = authService.register(registerDTO);
    
            return ResponseEntity.ok(response);
        }

}
