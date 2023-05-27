package com.example.spring_mvc.domain.role.repository;

import com.example.spring_mvc.domain.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
