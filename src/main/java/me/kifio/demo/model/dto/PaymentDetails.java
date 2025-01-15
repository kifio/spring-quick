package me.kifio.demo.model.dto;

public class PaymentDetails {
    String message;

    public PaymentDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
