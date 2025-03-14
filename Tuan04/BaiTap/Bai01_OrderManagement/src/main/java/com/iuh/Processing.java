package com.iuh;

public class Processing implements State{
    @Override
    public void doAction() {
        System.out.println("Đóng gói và vận chuyển.");
    }
}
