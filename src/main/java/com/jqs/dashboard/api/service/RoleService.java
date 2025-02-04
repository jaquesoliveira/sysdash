package com.jqs.dashboard.api.service;


import com.jqs.dashboard.api.entity.Role;
import com.jqs.dashboard.api.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> listar(){
        return repository.findAll();
    }
}
