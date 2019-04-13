package com.example.auth.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ApiResponse {
    private @Getter @Setter
    Boolean success;
    private @Getter @Setter
    String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}