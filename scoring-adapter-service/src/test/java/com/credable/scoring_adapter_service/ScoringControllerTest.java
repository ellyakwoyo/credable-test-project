package com.credable.scoring_adapter_service.controller;

import com.credable.scoring_adapter_service.model.ScoringResponse;
import com.credable.scoring_adapter_service.service.ScoringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScoringController.class)
class ScoringControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ScoringService scoringService;
    
    @Test
    void queryScore_ShouldReturnScoringResponse() throws Exception {
        ScoringResponse response = new ScoringResponse();
        response.setScore(750);
        response.setLimitAmount(50000.0);
        
        when(scoringService.queryScore("test-token")).thenReturn(response);
        
        mockMvc.perform(get("/api/v1/scoring/query-score/test-token"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.score").value(750))
               .andExpect(jsonPath("$.limitAmount").value(50000.0));
    }
}