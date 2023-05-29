package com.example.spring_mvc.domain.role.repository;

import com.example.spring_mvc.domain.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(Role.RoleName roleName);
}
