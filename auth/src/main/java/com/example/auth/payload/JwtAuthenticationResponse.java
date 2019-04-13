package com.example.auth.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JwtAuthenticationResponse {
    private @Getter @Setter
    String accessToken;
    private @Getter @Setter
    String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}