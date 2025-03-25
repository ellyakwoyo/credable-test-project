package com.credable.cbs_adapter_service.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CBSClient extends WebServiceGatewaySupport {

    public GetCustomerResponse getCustomer(String customerNumber) {
        GetCustomerRequest request = new GetCustomerRequest();
        request.setCustomerNumber(customerNumber);

        return (GetCustomerResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://credable.io/cbs/getCustomer"));
    }

    public class GetCustomerResponse {
        private Customer customer;
    
        public Customer getCustomer() {
            return customer;
        }
    
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }
}