package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {
    Page<UserDto> getUserDtoPage(Pageable pageable);
}
