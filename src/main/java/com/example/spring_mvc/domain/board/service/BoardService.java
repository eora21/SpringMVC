package com.example.spring_mvc.domain.board.service;

import com.example.spring_mvc.domain.board.entity.Board;
import com.example.spring_mvc.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Board getBoard() {
        return boardRepository.findById(1L)
                .orElseThrow(IllegalAccessError::new);
    }
}
