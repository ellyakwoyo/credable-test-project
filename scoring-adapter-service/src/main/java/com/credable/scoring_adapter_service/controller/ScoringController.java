package com.credable.scoring_adapter_service.controller;

import com.credable.scoring_adapter_service.model.RegistrationRequest;
import com.credable.scoring_adapter_service.model.RegistrationResponse;
import com.credable.scoring_adapter_service.model.ScoringResponse;
import com.credable.scoring_adapter_service.service.ScoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scoring")
@RequiredArgsConstructor
public class ScoringController {
    private final ScoringService scoringService;
    
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(scoringService.registerService(request));
    }
    
    @GetMapping("/query-score/{token}")
    public ResponseEntity<ScoringResponse> queryScore(@PathVariable String token) {
        return ResponseEntity.ok(scoringService.queryScore(token));
    }
}