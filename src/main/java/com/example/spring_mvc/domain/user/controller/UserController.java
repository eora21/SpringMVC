package com.example.spring_mvc.domain.user.controller;

import com.example.spring_mvc.domain.role.entity.Role;
import com.example.spring_mvc.domain.user.dto.request.UserSignUpDto;
import com.example.spring_mvc.domain.user.dto.response.UserResponseDto;
import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import com.example.spring_mvc.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUsersPage(Model model, Pageable pageable) {
        Page<UsersResponseDto> usersPage = userService.getUsersPage(pageable);
        model.addAttribute("usersPage", usersPage);
        return "users";
    }

    @PostMapping("signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String signUp(UserSignUpDto userSignUpDto) throws IOException {
        Long userId = userService.signUp(userSignUpDto);
        return "redirect:/user/" + userId;
    }

    @GetMapping("{userId}")
    public String userDetail(@PathVariable Long userId, Model model) {
        UserResponseDto user = userService.getUserDetail(userId);
        model.addAttribute("user", user);
        return "userDetail";
    }

    @GetMapping("/{userId}/update/role")
    public String roleUpdateView(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "userUpdateRoleForm";
    }

    @PatchMapping("/{userId}/update/role")
    public String roleUpdate(@PathVariable Long userId, @RequestParam Role.RoleName roleName) {
        userService.roleUpdate(userId, roleName);
        return "redirect:/user";
    }
}
