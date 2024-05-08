package com.ucb.demo.dto;

import java.time.LocalDateTime;

public class LoginResponse {
    private LocalDateTime timestamp;
    private String token;

    public String getToken() {
        return token;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}