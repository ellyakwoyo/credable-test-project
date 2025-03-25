package com.credable.scoring_adapter_service.model;

import lombok.Data;

@Data
public class ScoringResponse {
    private Long id;
    private String customerNumber;
    private Integer score;
    private Double limitAmount;
    private String exclusion;
    private String exclusionReason;
}