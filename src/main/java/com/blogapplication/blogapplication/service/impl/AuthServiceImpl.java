package com.blogapplication.blogapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.payload.LoginDTO;
import com.blogapplication.blogapplication.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    AuthenticationManager authenticationManager;


    @Override
    public String login(LoginDTO loginDTO) {
        System.out.println( loginDTO );
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("authentication");
        System.out.println(authentication);

        return "User Loggin Successfully";
    }
    
}
