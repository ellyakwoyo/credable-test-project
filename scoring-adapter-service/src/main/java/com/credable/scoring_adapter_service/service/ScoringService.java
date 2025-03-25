package com.credable.scoring_adapter_service.service;

import com.credable.scoring_adapter_service.client.ScoringClient;
import com.credable.scoring_adapter_service.model.RegistrationRequest;
import com.credable.scoring_adapter_service.model.RegistrationResponse;
import com.credable.scoring_adapter_service.model.ScoringResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScoringService {
    private final ScoringClient scoringClient;
    
    @Value("${scoring.retry.max-attempts}")
    private int maxAttempts;
    
    @Value("${scoring.retry.initial-delay}")
    private long initialDelay;
    
    @Value("${scoring.retry.multiplier}")
    private double multiplier;
    
    public ScoringService(ScoringClient scoringClient) {
        this.scoringClient = scoringClient;
    }
    
    public RegistrationResponse registerService(RegistrationRequest request) {
        return scoringClient.registerService(request);
    }
    
    @Retryable(
        maxAttemptsExpression = "${scoring.retry.max-attempts}",
        backoff = @Backoff(
            delayExpression = "${scoring.retry.initial-delay}",
            multiplierExpression = "${scoring.retry.multiplier}"
        )
    )
    public ScoringResponse queryScore(String token) {
        log.info("Attempting to query score with token: {}", token);
        return scoringClient.queryScore(token);
    }
}