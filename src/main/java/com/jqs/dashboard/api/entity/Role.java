package com.jqs.dashboard.api.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Table(name = "tb_role")
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "seq_role", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "role_name")
    private String roleName;


    @Override
    public String getAuthority() {
        return this.roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}