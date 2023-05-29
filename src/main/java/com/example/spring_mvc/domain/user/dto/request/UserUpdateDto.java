package com.example.spring_mvc.domain.user.dto.request;

import com.example.spring_mvc.domain.role.entity.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateDto {
    String password;
    String name;
    MultipartFile profileImage;
    Role.RoleName role;
}
