package com.iuh;

public class PaypalStrategy implements PaymentStrategy{
    private String emailId;
    private String password;

    public PaypalStrategy(String password, String emailId) {
        this.password = password;
        this.emailId = emailId;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}
