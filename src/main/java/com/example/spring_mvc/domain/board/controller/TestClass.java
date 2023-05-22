package com.example.spring_mvc.domain.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getTest() {
        return "TEST";
    }
}
