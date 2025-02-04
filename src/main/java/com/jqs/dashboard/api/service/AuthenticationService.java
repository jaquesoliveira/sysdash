package com.jqs.dashboard.api.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication) {

        try{
            jwtService.generateToken(authentication);
        }catch(Exception e){

        }
        return jwtService.generateToken(authentication);
    }

}