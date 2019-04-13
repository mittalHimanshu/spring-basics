package com.example.auth.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    private @Getter @Setter
    String usernameOrEmail;

    @NotBlank @Getter @Setter
    private String password;

}