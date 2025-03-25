package com.credable.lms_service.service;

import com.credable.lms_service.model.Loan;
import com.credable.lms_service.model.LoanResponse;
import com.credable.lms_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public LoanResponse requestLoan(String customerNumber, Double amount) {
        // Check for ongoing loan
        if (loanRepository.findByCustomerNumberAndStatus(customerNumber, "PENDING").isPresent()) {
            return new LoanResponse("FAILED", "Customer has an ongoing loan request", null);
        }

        // Save loan request
        Loan loan = new Loan();
        loan.setCustomerNumber(customerNumber);
        loan.setAmount(amount);
        loan.setStatus("PENDING");
        loanRepository.save(loan);

        return new LoanResponse("SUCCESS", "Loan request submitted", loan.getId().toString());
    }
}