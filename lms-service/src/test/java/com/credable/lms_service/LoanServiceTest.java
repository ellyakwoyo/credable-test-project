package com.credable.lms_service;

import com.credable.lms_service.model.Loan;
import com.credable.lms_service.service.LoanService;
import com.credable.lms_service.model.LoanResponse;
import com.credable.lms_service.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    @Test
    public void testRequestLoan() {
        // Mock the repository behavior
        when(loanRepository.findByCustomerNumberAndStatus(any(), any())).thenReturn(Optional.empty());
        when(loanRepository.save(any())).thenReturn(new Loan());

        // Test the service method
        LoanResponse response = loanService.requestLoan("12345", 10000.0);
        assertNotNull(response);
    }
}