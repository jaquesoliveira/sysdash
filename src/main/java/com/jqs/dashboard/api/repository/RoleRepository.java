package com.jqs.dashboard.api.repository;

import com.jqs.dashboard.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
