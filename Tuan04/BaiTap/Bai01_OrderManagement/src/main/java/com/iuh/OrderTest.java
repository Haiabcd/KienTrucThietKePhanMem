package com.iuh;

public class OrderTest {
    public static void main(String[] args) {
        OrderContext context = new OrderContext();

        State newState = new NewCreate();
        State proState = new Processing();
        State deState = new Delivered();
        State caState = new Cancel();

        context.setOrderState(newState);
        context.doAction();

        context.setOrderState(proState);
        context.doAction();

        context.setOrderState(deState);
        context.doAction();

        context.setOrderState(caState);
        context.doAction();
    }
}
