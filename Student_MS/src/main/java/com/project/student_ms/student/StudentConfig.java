package com.project.student_ms.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student st1 = new Student(
                    1L,
                    "Jordan",
                    "J2@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student st2 = new Student(
                    2L,
                    "Jordan2",
                    "J@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 8)
            );

            repository.saveAll(List.of(st1, st2));

        };
    }
}
