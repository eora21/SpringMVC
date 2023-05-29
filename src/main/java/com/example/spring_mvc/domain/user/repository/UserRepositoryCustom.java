package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {
    Page<UsersResponseDto> getUserDtoPage(Pageable pageable);
}
