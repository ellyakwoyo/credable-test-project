package com.credable.scoring_adapter_service.model;

import lombok.Data;

@Data
public class RegistrationResponse {
    private Long id;
    private String url;
    private String name;
    private String username;
    private String password;
    private String token;
}