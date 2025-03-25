package com.credable.scoring_adapter_service.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrationRequest {
    @NotBlank
    private String url;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
}