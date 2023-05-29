package com.example.spring_mvc.domain.user.repository;

import com.example.spring_mvc.domain.user.dto.response.QUsersResponseDto;
import com.example.spring_mvc.domain.user.dto.response.UsersResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.spring_mvc.domain.role.entity.QRole.role;
import static com.example.spring_mvc.domain.user.entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UsersResponseDto> getUserDtoPage(Pageable pageable) {
        List<UsersResponseDto> content = getContent(pageable);
        long total = getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private List<UsersResponseDto> getContent(Pageable pageable) {
        return queryFactory
                .select(new QUsersResponseDto(
                        user.id,
                        user.name,
                        role.roleName)
                )
                .from(user)
                .innerJoin(user.role, role)
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
