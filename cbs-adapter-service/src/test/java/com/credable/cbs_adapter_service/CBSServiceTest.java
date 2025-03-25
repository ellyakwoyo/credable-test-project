package com.credable.cbs_adapter_service.service;

import com.credable.cbs_adapter_service.client.CBSClient;
import com.credable.cbs_adapter_service.wsdl.GetCustomerResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CBSServiceTest {
    
    @Mock
    private CBSClient cbsClient;
    
    @InjectMocks
    private CBSService cbsService;
    
    @Test
    void getCustomer_Success() {
        GetCustomerResponse mockResponse = new GetCustomerResponse();
        when(cbsClient.getCustomer("12345")).thenReturn(mockResponse);
        
        GetCustomerResponse response = cbsService.getCustomer("12345");
        
        assertNotNull(response);
        assertEquals(mockResponse, response);
        verify(cbsClient, times(1)).getCustomer("12345");
    }
}