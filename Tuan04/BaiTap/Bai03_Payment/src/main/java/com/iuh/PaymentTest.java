package com.iuh;

import com.iuh.decorator.DiscountDecorator;
import com.iuh.decorator.ProcessingFeeDecorator;

public class PaymentTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100);
        cart.addItem(50);

        System.out.println("Total Amount: " + cart.getTotalAmount());

        // Pay with Credit Card and Processing Fee
        PaymentStrategy creditCardPayment = new CreditCardStrategy("John Doe", "1234567890123456", "123", "12/25");
        PaymentStrategy creditCardWithFee = new ProcessingFeeDecorator(creditCardPayment);
        cart.pay(creditCardWithFee);

        // Pay with PayPal and apply discount
        PaymentStrategy paypalPayment = new PaypalStrategy("john@example.com", "password123");
        PaymentStrategy paypalWithDiscount = new DiscountDecorator(paypalPayment);
        cart.pay(paypalWithDiscount);
    }
}
