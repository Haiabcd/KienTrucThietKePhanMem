package com.iuh;

public class Cancel implements State{
    @Override
    public void doAction() {
        System.out.println("Hủy đơn hàng và hoàn tiền.");
    }
}
