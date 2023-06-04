package com.example.spring_mvc.domain.user.service;

import com.example.spring_mvc.domain.role.entity.Role;
import com.example.spring_mvc.domain.role.repository.RoleRepository;
import com.example.spring_mvc.domain.user.dto.request.UserSignUpDto;
import com.example.spring_mvc.domain.user.dto.response.UserResponseDto;
import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import com.example.spring_mvc.domain.user.entity.User;
import com.example.spring_mvc.domain.user.repository.UserRepository;
import com.example.spring_mvc.exception.NotFoundException;
import com.example.spring_mvc.util.ProfileImageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProfileImageHelper profileImageHelper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<UsersResponseDto> getUsersPage(Pageable pageable) {
        return userRepository.getUsersPage(pageable);
    }

    @Transactional
    public Long signUp(UserSignUpDto userSignUpDto) throws IOException {
        String profileImageUrl = profileImageHelper.uploadProfileImage(userSignUpDto.getProfileImage());
        Role role = roleRepository.findByRoleName(userSignUpDto.getRoleName())
                .orElseThrow(NotFoundException::new);

        User user = User.builder()
                .loginId(userSignUpDto.getLoginId())
                .password(userSignUpDto.getPassword())
                .name(userSignUpDto.getName())
                .role(role)
                .profileImage(profileImageUrl)
                .build();

        return userRepository.save(user).getId();
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserDetail(long userId) {
        UserResponseDto userDetailDto = userRepository.getUserResponseDtoById(userId)
                .orElseThrow(NotFoundException::new);
        String profileImage = profileImageHelper.getProfileImage(userDetailDto.getProfileImage());
        userDetailDto.setProfileImage(profileImage);
        return userDetailDto;
    }

    @Transactional
    public void roleUpdate(Long userId, Role.RoleName roleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundException::new);
        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(NotFoundException::new);
        user.setRole(role);
    }
}
