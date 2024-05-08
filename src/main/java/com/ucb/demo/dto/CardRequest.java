package com.ucb.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CardRequest {

    @NotNull
    @Pattern(regexp = "^[0-9]{16}$")
    private String cardNumber;

    @NotNull
    @Pattern(regexp = "^[0-9]{3}$")
    private String cvv;

    @NotNull
    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/[0-9]{2}$")
    private String expirationDate;

    public CardRequest() {
    }

    public CardRequest(String cardNumber, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
