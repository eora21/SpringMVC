package com.example.spring_mvc.domain.user.service;

import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import com.example.spring_mvc.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UsersResponseDto> getUsersPage(Pageable pageable) {
        return userRepository.getUsersPage(pageable);
    }
}
