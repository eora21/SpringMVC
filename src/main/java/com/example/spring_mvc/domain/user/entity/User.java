package com.example.spring_mvc.domain.user.entity;

import com.example.spring_mvc.domain.role.entity.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_login_id")
    private String loginId;

    @Setter
    @Column(name = "user_password")
    private String password;

    @Setter
    @Column(name = "user_name")
    private String name;

    @Setter
    @Column(name = "user_profile_image")
    private String profileImage;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id")
    private Role role;

    @Builder
    private User(String loginId, String password, String name, String profileImage, Role role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.profileImage = profileImage;
        this.role = role;
    }
}
