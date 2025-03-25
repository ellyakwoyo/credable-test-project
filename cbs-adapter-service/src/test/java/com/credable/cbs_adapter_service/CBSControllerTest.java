package com.credable.cbs_adapter_service.controller;

import com.credable.cbs_adapter_service.wsdl.GetCustomerResponse;
import com.credable.cbs_adapter_service.service.CBSService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CBSController.class)
class CBSControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CBSService cbsService;
    
    @Test
    void getCustomer_ShouldReturnCustomerData() throws Exception {
        GetCustomerResponse response = new GetCustomerResponse();
        when(cbsService.getCustomer("12345")).thenReturn(response);
        
        mockMvc.perform(get("/api/v1/cbs/customers/12345"))
               .andExpect(status().isOk());
    }
}