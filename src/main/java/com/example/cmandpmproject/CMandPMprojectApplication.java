package com.example.cmandpmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CMandPMprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CMandPMprojectApplication.class, args);
    }

}
