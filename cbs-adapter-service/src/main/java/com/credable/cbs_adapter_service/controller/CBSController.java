package com.credable.cbs_adapter_service.controller;

import com.credable.cbs_adapter_service.service.CBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cbs")
public class CBSController {

    @Autowired
    private CBSService cbsService;

    @GetMapping("/customer/{customerNumber}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerNumber) {
        return ResponseEntity.ok(cbsService.getCustomer(customerNumber));
    }
}
