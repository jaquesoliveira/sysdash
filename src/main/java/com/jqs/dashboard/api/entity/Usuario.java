package com.jqs.dashboard.api.entity;

import com.jqs.dashboard.api.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="tb_usuario_acompanhamento")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
@Data
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "senha")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<Role> roles;

    public Usuario(String username) {
        this.username = username;
    }
}
