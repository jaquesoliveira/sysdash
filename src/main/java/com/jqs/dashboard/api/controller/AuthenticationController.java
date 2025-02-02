package com.jqs.dashboard.api.controller;

import com.jqs.dashboard.api.dto.ResponseLogin;
import com.jqs.dashboard.api.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("authenticate")
    public ResponseEntity<Object> authenticate(
            Authentication authentication) {
        try{
            var res =authenticationService.authenticate(authentication);
            ResponseLogin responseLogin = new ResponseLogin(res);
            return ResponseEntity.ok(responseLogin);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Houve um erro");
        }
    }
}