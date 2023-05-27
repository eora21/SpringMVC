package com.example.spring_mvc.domain.board.repository;

import com.example.spring_mvc.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
