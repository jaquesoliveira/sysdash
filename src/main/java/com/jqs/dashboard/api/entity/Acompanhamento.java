package com.jqs.dashboard.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="tb_acompanhamento")
@SequenceGenerator(name = "seq_acompanhamento", sequenceName = "seq_acompanhamento", allocationSize = 1)
@Data
@NoArgsConstructor
public class Acompanhamento implements Serializable {
    @Id
    @GeneratedValue(generator = "seq_acompanhamento", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "data")
    private LocalDate data;
    @OneToOne
    @JoinColumn(name="usuario", referencedColumnName = "id")
    private Usuario usuario;

    public Acompanhamento(String tipo, Usuario usuario) {
        this.tipo = tipo;
        this.usuario = usuario;
    }
}
