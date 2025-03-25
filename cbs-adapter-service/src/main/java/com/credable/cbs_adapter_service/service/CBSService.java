package com.credable.cbs_adapter_service.service;

import com.credable.cbs_adapter_service.client.CBSClient;
import com.credable.cbs_adapter_service.wsdl.GetCustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CBSService {
    private final CBSClient cbsClient;

    public GetCustomerResponse getCustomer(String customerNumber) {
        log.info("Fetching customer data for: {}", customerNumber);
        return cbsClient.getCustomer(customerNumber);
    }
}