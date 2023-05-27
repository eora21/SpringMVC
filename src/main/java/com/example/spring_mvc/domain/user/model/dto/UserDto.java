package com.example.spring_mvc.domain.user.model.dto;

import com.example.spring_mvc.domain.role.entity.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UserDto {
    private final String loginId;
    private final String name;
    private final Role.RoleName roleName;

    @QueryProjection
    public UserDto(String loginId, String name, Role.RoleName roleName) {
        this.loginId = loginId;
        this.name = name;
        this.roleName = roleName;
    }
}
