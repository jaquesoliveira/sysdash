package com.jqs.dashboard.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AcompanhamentoRSDto {
    private String usuario;
    private long prospect;
    private long contato;
    private Long qualificado;

    public AcompanhamentoRSDto(String usuario, long prospect, long contato, Long qualificado) {
        this.usuario = usuario;
        this.prospect = prospect;
        this.contato = contato;
        this.qualificado = qualificado;
    }
}
