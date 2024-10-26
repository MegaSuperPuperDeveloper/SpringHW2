package com.example.springhw2.config;

import com.example.springhw2.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public StudentService studentService() {
        return new StudentService();
    }

}