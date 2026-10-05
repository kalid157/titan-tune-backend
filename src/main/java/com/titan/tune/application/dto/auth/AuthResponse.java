package com.titan.tune.application.dto.auth;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthResponse {
    private String token;
    private String id;
    private String trackingId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Boolean isPremium;
    @Builder.Default
    private String type = "Bearer";
}
