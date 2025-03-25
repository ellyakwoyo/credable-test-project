package com.credable.scoring_adapter_service.client;

import com.credable.scoring_adapter_service.model.RegistrationRequest;
import com.credable.scoring_adapter_service.model.RegistrationResponse;
import com.credable.scoring_adapter_service.model.ScoringResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScoringClient {
    private final RestTemplate restTemplate;
    
    @Value("${scoring.engine.url}")
    private String scoringEngineUrl;
    
    @Value("${scoring.engine.client-token}")
    private String clientToken;
    
    public ScoringClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public RegistrationResponse registerService(RegistrationRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RegistrationRequest> entity = new HttpEntity<>(request, headers);
        
        return restTemplate.postForObject(
            scoringEngineUrl + "/api/v1/client/createClient",
            entity,
            RegistrationResponse.class
        );
    }
    
    public ScoringResponse queryScore(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", clientToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<ScoringResponse> response = restTemplate.exchange(
            scoringEngineUrl + "/api/v1/scoring/queryScore/" + token,
            HttpMethod.GET,
            entity,
            ScoringResponse.class
        );
        
        return response.getBody();
    }
}