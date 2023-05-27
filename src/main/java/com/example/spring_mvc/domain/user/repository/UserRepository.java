package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
