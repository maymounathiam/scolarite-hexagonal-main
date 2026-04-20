package com.logistique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = {
                "com.logistique.infrastructure.persistence",
                "com.logistique.infrastructure.projection"
        }
)
@EntityScan(
        basePackages = {
                "com.logistique.infrastructure.persistence",
                "com.logistique.infrastructure.projection"
        }
)
@EnableScheduling
public class LogistiqueHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogistiqueHexagonalApplication.class, args);
    }
}
