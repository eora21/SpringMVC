package com.example.spring_mvc.domain.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TestClass {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getTest() {
        return "test";
    }
}
