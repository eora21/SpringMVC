package com.example.spring_mvc.domain.board.entity;

import com.example.spring_mvc.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board {
    @Id
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;

    @Column(name = "view_count")
    private int viewCount;

    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
        this.updateDateTime = LocalDateTime.now();
    }

    public void increaseViewCount() {
        this.viewCount++;
    }
}
