package com.example.spring_mvc.domain.user.service;

import com.example.spring_mvc.domain.user.model.dto.UserDto;
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
    public Page<UserDto> getUserDtoPage(Pageable pageable) {
        return userRepository.getUserDtoPage(pageable);
    }
}
