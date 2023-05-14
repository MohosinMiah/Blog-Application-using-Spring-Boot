package com.blogapplication.blogapplication.payload;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
    
    private String accessToken;
    private String tokenType = "Bearer";
    
}
