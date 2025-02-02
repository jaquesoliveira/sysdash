package com.jqs.dashboard.api.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsuarioDto{
    private Long id;
    private String username;

    public UsuarioDto(String username) {
        this.id = id;
        this.username = username;
    }
}
