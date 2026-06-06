package com.example.springbootpractice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequest {
    @NotBlank(message = "username.is.blank")
    @NotNull(message = "username.is.null")
    private String username;
    @NotBlank(message = "password.is.blank")
    @NotNull(message = "password.is.null")
    private String password;

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
