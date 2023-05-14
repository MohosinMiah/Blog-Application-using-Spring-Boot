package com.blogapplication.blogapplication.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapplication.blogapplication.entity.Role;
import com.blogapplication.blogapplication.entity.User;
import com.blogapplication.blogapplication.exception.BlogAPIException;
import com.blogapplication.blogapplication.payload.LoginDTO;
import com.blogapplication.blogapplication.payload.RegisterDTO;
import com.blogapplication.blogapplication.repository.RoleRepository;
import com.blogapplication.blogapplication.repository.UserRepository;
import com.blogapplication.blogapplication.security.JwtTokenProvider;
import com.blogapplication.blogapplication.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }


    @Override
    public String register(RegisterDTO registerDTO) {
        // Check username is exist in database or not
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new BlogAPIException( HttpStatus.BAD_REQUEST, "Username is alrady exist");
        }

        // Check email is exist in database or not
        if(userRepository.existsByUsername(registerDTO.getEmail())){
            throw new BlogAPIException( HttpStatus.BAD_REQUEST, "Email is alrady exist");
        }

        User user = new User();

        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER").get();

        roles.add(userRole);
        
        // Set Role to the user
        user.setRoles(roles);

        // Save user After Assign role . By default all user will get ROLE_USER authorizom
        userRepository.save(user);



        return "Registration Sucess";
    }
    
}
