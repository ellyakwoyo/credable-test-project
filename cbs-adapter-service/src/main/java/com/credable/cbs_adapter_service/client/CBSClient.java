package com.credable.cbs_adapter_service.client;

import com.credable.cbs_adapter_service.config.CbsSoapProperties;
import com.credable.cbs_adapter_service.wsdl.GetCustomerRequest;
import com.credable.cbs_adapter_service.wsdl.GetCustomerResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CBSClient extends WebServiceGatewaySupport {
    private final CbsSoapProperties properties;

    public CBSClient(CbsSoapProperties properties) {
        this.properties = properties;
    }

    public GetCustomerResponse getCustomer(String customerNumber) {
        GetCustomerRequest request = new GetCustomerRequest();
        request.setCustomerNumber(customerNumber);

        return (GetCustomerResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                    properties.getServiceUrl(),
                    request,
                    new SoapActionCallback(properties.getActionUri())
                );
    }
}