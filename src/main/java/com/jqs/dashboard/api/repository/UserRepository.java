package com.jqs.dashboard.api.repository;

//import com.jqs.dashboard.api.entity.User;
import com.jqs.dashboard.api.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
}
