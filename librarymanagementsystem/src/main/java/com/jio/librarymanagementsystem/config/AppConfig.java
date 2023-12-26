package com.jio.librarymanagementsystem.config;

import com.jio.librarymanagementsystem.service.BookService;
import com.jio.librarymanagementsystem.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }

}