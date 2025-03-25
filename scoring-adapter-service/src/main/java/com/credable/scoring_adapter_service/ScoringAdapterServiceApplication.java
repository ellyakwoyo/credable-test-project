package com.credable.scoring_adapter_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class ScoringAdapterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoringAdapterServiceApplication.class, args);
    }
}