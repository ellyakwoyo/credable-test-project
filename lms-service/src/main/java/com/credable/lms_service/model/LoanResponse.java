package com.credable.lms_service.model;

public class LoanResponse {
    private String status;
    private String message;
    private String loanId;

    // Constructor
    public LoanResponse(String status, String message, String loanId) {
        this.status = status;
        this.message = message;
        this.loanId = loanId;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}