package com.jqs.dashboard.api.dto;

import com.jqs.dashboard.api.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AcompanhamentoDto2 {
    private String tipo;
    private UsuarioDto usuario;

    public AcompanhamentoDto2(String tipo, UsuarioDto usuario) {
        this.tipo = tipo;
        this.usuario = usuario;
    }
}
