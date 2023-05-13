package com.blogapplication.blogapplication.service;

import com.blogapplication.blogapplication.payload.LoginDTO;
import com.blogapplication.blogapplication.payload.RegisterDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
    
    String register(RegisterDTO registerDTO);
}
