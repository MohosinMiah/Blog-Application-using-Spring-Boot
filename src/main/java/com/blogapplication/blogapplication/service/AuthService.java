package com.blogapplication.blogapplication.service;

import com.blogapplication.blogapplication.payload.LoginDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
}
