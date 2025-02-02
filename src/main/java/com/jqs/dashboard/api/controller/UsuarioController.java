package com.jqs.dashboard.api.controller;

import com.jqs.dashboard.api.entity.Usuario;
import com.jqs.dashboard.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/usuario")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Object> salvar(@RequestBody Usuario usuario){
        try{
            service.salvar(usuario);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Object> listar(){
        try{
            var listUsuarios = service.listar();
            return ResponseEntity.ok(listUsuarios);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
