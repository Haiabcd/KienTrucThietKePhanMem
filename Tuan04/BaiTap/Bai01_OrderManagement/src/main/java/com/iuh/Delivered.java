package com.iuh;

public class Delivered implements State{
    @Override
    public void doAction() {
        System.out.println("Cập nhật trạng thái đơn hàng là đã giao.");
    }
}
