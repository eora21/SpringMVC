package com.example.spring_mvc.domain.user.model.dto;

import com.example.spring_mvc.domain.role.entity.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserDto {
    private final Long id;
    private final String name;
    private final Role.RoleName roleName;

    @QueryProjection
    public UserDto(Long id, String name, Role.RoleName roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }
}
