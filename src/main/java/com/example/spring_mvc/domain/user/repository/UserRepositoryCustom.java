package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.dto.response.UserResponseDto;
import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserRepositoryCustom {
    Page<UsersResponseDto> getUsersPage(Pageable pageable);

    Optional<UserResponseDto> getUserResponseDtoById(long userId);
}
