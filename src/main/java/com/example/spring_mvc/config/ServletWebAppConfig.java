package com.example.spring_mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.spring_mvc.domain.**.controller")
public class ServletWebAppConfig {

}
