package com.iuh.decorator;

public class SpecialEditionBorrow extends BorrowDecorator{
    public SpecialEditionBorrow(Borrow borrow) {
        super(borrow);
    }

    @Override
    public void borrow() {
        borrow.borrow();
        System.out.println("Yêu cầu phiên bản đặc biệt");
    }
}
