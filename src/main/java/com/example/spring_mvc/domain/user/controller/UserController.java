package com.example.spring_mvc.domain.user.controller;

import com.example.spring_mvc.domain.user.model.dto.UserDto;
import com.example.spring_mvc.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public Page<UserDto> getUserDtoPage(Pageable pageable) {
        return userService.getUserDtoPage(pageable);
    }
}