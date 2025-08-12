package com.nisha.spring.finalex.model;

public class Payment {
    private String cardNumber;
    private double amount;
    private String paymentStatus;

    public Payment() {}

    public Payment(String cardNumber, double amount, String paymentStatus) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
