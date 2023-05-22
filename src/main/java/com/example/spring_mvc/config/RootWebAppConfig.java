package com.example.spring_mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.example.spring_mvc.domain", excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootWebAppConfig {

}
