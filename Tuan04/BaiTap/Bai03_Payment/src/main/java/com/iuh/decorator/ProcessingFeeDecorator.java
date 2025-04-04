package com.iuh.decorator;

import com.iuh.PaymentStrategy;

public class ProcessingFeeDecorator extends PaymentDecorator{
    public ProcessingFeeDecorator(PaymentStrategy decoratedPayment) {
        super(decoratedPayment);
    }

    @Override
    public void pay(int amount) {
        int fee = 5;
        System.out.println("\n" +
                "Thêm phí xử lý: " + fee);
        super.pay(amount + fee);
    }
}
