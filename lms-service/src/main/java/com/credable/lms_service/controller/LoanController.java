package com.credable.lms_service.controller;

import com.credable.lms_service.model.LoanRequest;
import com.credable.lms_service.model.LoanResponse;
import com.credable.lms_service.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/loan-request")
    public ResponseEntity<LoanResponse> requestLoan(@Valid @RequestBody LoanRequest request) {
        LoanResponse response = loanService.requestLoan(request.getCustomerNumber(), request.getAmount());
        return ResponseEntity.ok(response);
    }
}