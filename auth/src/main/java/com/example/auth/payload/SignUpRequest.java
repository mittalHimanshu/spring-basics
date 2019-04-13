package com.example.auth.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Data
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private @Getter @Setter
    String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private @Getter @Setter
    String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private @Getter @Setter
    String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private @Getter @Setter
    String password;

}