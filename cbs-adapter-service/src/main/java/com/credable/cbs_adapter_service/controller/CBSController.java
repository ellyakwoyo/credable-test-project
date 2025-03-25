package com.credable.cbs_adapter_service.controller;

import com.credable.cbs_adapter_service.service.CBSService;
import com.credable.cbs_adapter_service.wsdl.GetCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cbs")
@RequiredArgsConstructor
public class CBSController {
    private final CBSService cbsService;

    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable String customerNumber) {
        return ResponseEntity.ok(cbsService.getCustomer(customerNumber));
    }
}