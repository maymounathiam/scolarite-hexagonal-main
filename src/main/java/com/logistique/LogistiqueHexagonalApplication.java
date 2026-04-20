package com.logistique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.logistique.infrastructure.persistence")
@EntityScan(basePackages = "com.logistique.infrastructure.persistence")
public class LogistiqueHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogistiqueHexagonalApplication.class, args);
    }
}
