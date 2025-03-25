// package com.credable.cbs_adapter_service.config;

// import com.credable.cbs_adapter_service.client.CBSClient;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.oxm.jaxb.Jaxb2Marshaller;
// import org.springframework.ws.client.support.interceptor.ClientInterceptor;
// import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

// @Configuration
// public class WebServiceConfig {
//     private final CbsSoapProperties properties;

//     public WebServiceConfig(CbsSoapProperties properties) {
//         this.properties = properties;
//     }

//     @Bean
//     public Jaxb2Marshaller marshaller() {
//         Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//         marshaller.setContextPath("com.credable.cbs_adapter_service.wsdl");
//         return marshaller;
//     }

//     @Bean
//     public CBSClient cbsClient(Jaxb2Marshaller marshaller) {
//         CBSClient client = new CBSClient(properties);
//         client.setDefaultUri(properties.getEndpoint());
//         client.setMarshaller(marshaller);
//         client.setUnmarshaller(marshaller);
//         client.setInterceptors(new ClientInterceptor[]{securityInterceptor()});
//         return client;
//     }

//     @Bean
//     public Wss4jSecurityInterceptor securityInterceptor() {
//         Wss4jSecurityInterceptor interceptor = new Wss4jSecurityInterceptor();
//         interceptor.setSecurementActions("UsernameToken");
//         interceptor.setSecurementUsername(properties.getUsername());
//         interceptor.setSecurementPassword(properties.getPassword());
//         interceptor.setSecurementPasswordType("PasswordText");
//         return interceptor;
//     }
// }