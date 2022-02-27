package com.project.student_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.student_ms","com.project.student_ms.student"})
public class StudentMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentMsApplication.class, args);
    }
}
