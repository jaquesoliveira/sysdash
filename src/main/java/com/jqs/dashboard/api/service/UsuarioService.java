package com.jqs.dashboard.api.service;

import com.jqs.dashboard.api.UserNotFoundException;
import com.jqs.dashboard.api.entity.Usuario;
import com.jqs.dashboard.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


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

    public Usuario findByName(String userName) throws UserNotFoundException{
        return repository.findByUsername(userName)
                .orElseThrow(() -> new UserNotFoundException());
    }

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public void excluir(final Long id){
        repository.deleteById(id);
    }
}
