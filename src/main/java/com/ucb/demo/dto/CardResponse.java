package com.ucb.demo.dto;

public class CardResponse {

    private int statusCode;
    private String message;

    public CardResponse() {
        this.statusCode = 0;
        this.message = "Successful";
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

