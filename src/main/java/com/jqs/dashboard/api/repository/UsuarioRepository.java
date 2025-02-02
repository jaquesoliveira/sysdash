package com.jqs.dashboard.api.repository;

import com.jqs.dashboard.api.entity.Acompanhamento;
import com.jqs.dashboard.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}
