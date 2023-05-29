package com.example.spring_mvc.domain.user.controller;

import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import com.example.spring_mvc.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUserDtoPage(Model model, Pageable pageable) {
        Page<UsersResponseDto> userDtoPage = userService.getUserDtoPage(pageable);
        model.addAttribute("userDtoPage", userDtoPage);
        return "users";
    }
}
