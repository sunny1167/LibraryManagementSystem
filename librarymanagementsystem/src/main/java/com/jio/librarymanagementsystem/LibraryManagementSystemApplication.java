package com.jio.librarymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jio.librarymanagementsystem")
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

}


