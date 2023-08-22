package com.ascii274;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ascii274.login.repository"})
@ComponentScan({"com.ascii274.login","com.ascii274.login.repository"})
@EntityScan("com.ascii274.login.entity")
@EnableJpaRepositories("com.ascii274.login.repository")
public class BahayLoginServicesApp {
    public static void main(String[] args) {
        SpringApplication.run(BahayLoginServicesApp.class, args);
    }
}