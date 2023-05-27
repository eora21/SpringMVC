package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.model.dto.QUserDto;
import com.example.spring_mvc.domain.user.model.dto.UserDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.spring_mvc.domain.user.entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UserDto> getUserDtoPage(Pageable pageable) {
        List<UserDto> content = getContent(pageable);
        long total = getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private List<UserDto> getContent(Pageable pageable) {
        return queryFactory
                .select(new QUserDto(
                        user.loginId,
                        user.name,
                        user.role.roleName)
                )
                .from(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private Long getTotal() {
        return queryFactory
                .select(user.count())
                .from(user)
                .fetchOne();
    }
}
