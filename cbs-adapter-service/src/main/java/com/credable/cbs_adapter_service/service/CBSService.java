package com.credable.cbs_adapter_service.service;

import com.credable.cbs_adapter_service.client.CBSClient;
import com.credable.cbs_adapter_service.client.Customer; // Import the Customer class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CBSService {

    @Autowired
    private CBSClient cbsClient;

    public Customer getCustomer(String customerNumber) {
        return cbsClient.getCustomer(customerNumber).getCustomer();
    }
}