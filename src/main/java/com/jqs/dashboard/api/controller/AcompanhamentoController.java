package com.jqs.dashboard.api.controller;

import com.jqs.dashboard.api.dto.AcompanhamentoDto;
import com.jqs.dashboard.api.dto.AcompanhamentoRSDto;
import com.jqs.dashboard.api.entity.Acompanhamento;
import com.jqs.dashboard.api.service.AcompanhamentoService;
import com.jqs.dashboard.api.service.AuthenticationService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("api/v1/acompanhamento")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@CrossOrigin(origins = "*")
public class AcompanhamentoController {

    private final AcompanhamentoService service;

    @PostMapping
    public ResponseEntity<Object> salvar(Principal principal, @RequestBody AcompanhamentoDto acompanhamento){
        try{
            service.salvar(acompanhamento, principal.getName());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar(){
        try{
            var listAcompanhamentos = service.listar();
            return ResponseEntity.ok(listAcompanhamentos);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(Principal principal, @PathVariable("id") Long id){
        try{
            System.out.println(principal.getName());
            var resp = service.finaById(id).orElseThrow(() -> new RuntimeException("Acompanhamento não encontrado"));
            return ResponseEntity.ok(resp);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("userName")
    public ResponseEntity<Object> findByName(Principal principal){
        try{
            var resp = service.findByName(principal.getName());
            return ResponseEntity.ok(resp);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("todos")
    public ResponseEntity<Object> findAllByName(AuthenticationService authenticationService){
        System.out.println();
        try{
            var resp = service.findAllByName();
            return ResponseEntity.ok(resp);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
