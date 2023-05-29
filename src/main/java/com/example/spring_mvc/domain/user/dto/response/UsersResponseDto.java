package com.example.spring_mvc.domain.user.dto.response;

import com.example.spring_mvc.domain.role.entity.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private final Long id;
    private final String name;
    private final Role.RoleName roleName;

    @QueryProjection
    public UsersResponseDto(Long id, String name, Role.RoleName roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }
}
