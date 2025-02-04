package com.jqs.dashboard.api.controller;

import com.jqs.dashboard.api.dto.ResponseLogin;
import com.jqs.dashboard.api.service.AuthenticationService;
import com.jqs.dashboard.api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UsuarioService usuarioService;

    public AuthenticationController(AuthenticationService authenticationService, UsuarioService usuarioService) {
        this.authenticationService = authenticationService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("authenticate")
    public ResponseEntity<Object> authenticate(
            Authentication authentication) {
        try{
            var res =authenticationService.authenticate(authentication);
            var userName = authentication.getName();
            var usuarioLogado = usuarioService.findByName(userName);

            ResponseLogin responseLogin = new ResponseLogin(res, usuarioLogado.getNome(), usuarioLogado.getRoles().get(0).getRoleName());
            return ResponseEntity.ok(responseLogin);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Houve um erro");
        }
    }
}