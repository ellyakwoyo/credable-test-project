package com.credable.scoring_adapter_service.service;

import com.credable.scoring_adapter_service.client.ScoringClient;
import com.credable.scoring_adapter_service.model.ScoringResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.retry.annotation.EnableRetry;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@EnableRetry
class ScoringServiceTest {
    
    @Mock
    private ScoringClient scoringClient;
    
    @InjectMocks
    private ScoringService scoringService;
    
    @Test
    void queryScore_Success() {
        ScoringResponse expectedResponse = new ScoringResponse();
        when(scoringClient.queryScore("valid-token")).thenReturn(expectedResponse);
        
        ScoringResponse actualResponse = scoringService.queryScore("valid-token");
        
        assertEquals(expectedResponse, actualResponse);
        verify(scoringClient, times(1)).queryScore("valid-token");
    }
    
    @Test
    void queryScore_RetryOnFailure() {
        ScoringResponse expectedResponse = new ScoringResponse();
        when(scoringClient.queryScore("retry-token"))
            .thenThrow(new RuntimeException("First attempt failed"))
            .thenThrow(new RuntimeException("Second attempt failed"))
            .thenReturn(expectedResponse);
        
        ScoringResponse actualResponse = scoringService.queryScore("retry-token");
        
        assertEquals(expectedResponse, actualResponse);
        verify(scoringClient, times(3)).queryScore("retry-token");
    }
}