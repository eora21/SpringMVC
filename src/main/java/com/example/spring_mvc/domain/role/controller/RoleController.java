package com.example.spring_mvc.domain.role.controller;

import com.example.spring_mvc.domain.role.entity.Role;
import com.example.spring_mvc.domain.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Role test() {
        return roleService.getRole(1);
    }
}
