package com.example.spring_mvc.domain.user.dto.response;

import com.example.spring_mvc.domain.role.entity.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String name;

    @Setter
    private String profileImage;

    private final Role.RoleName roleName;

    @QueryProjection
    public UserResponseDto(Long id, String name, String profileImage, Role.RoleName roleName) {
        this.id = id;
        this.name = name;
        this.profileImage = profileImage;
        this.roleName = roleName;
    }
}
