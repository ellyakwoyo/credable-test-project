package com.credable.lms_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerNumber;
    private Double amount;
    private String status;
    private String loanId;
    private Integer score;
    private Double limitAmount;
}