package com.example.spring_mvc.domain.role.service;

import com.example.spring_mvc.domain.role.entity.Role;
import com.example.spring_mvc.domain.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    @Transactional
    public Role getRole(int id) {
        return roleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
