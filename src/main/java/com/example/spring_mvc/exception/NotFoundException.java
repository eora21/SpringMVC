package com.example.spring_mvc.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("해당하는 데이터를 찾을 수 없습니다.");
    }
}
