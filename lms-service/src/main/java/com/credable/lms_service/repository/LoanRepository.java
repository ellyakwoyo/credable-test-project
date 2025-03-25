package com.credable.lms_service.repository;

import java.util.Optional;
import com.credable.lms_service.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByCustomerNumberAndStatus(String customerNumber, String status);
}