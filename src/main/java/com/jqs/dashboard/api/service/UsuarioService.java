package com.jqs.dashboard.api.service;

import com.jqs.dashboard.api.entity.Usuario;
import com.jqs.dashboard.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UsuarioService {

    private final UsuarioRepository repository;

    public void salvar(Usuario usuario){
        var senhaEncriptada = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(senhaEncriptada);
        repository.save(usuario);
    }



    public List<Usuario> listar(){
        return repository.findAll();
    }
}
