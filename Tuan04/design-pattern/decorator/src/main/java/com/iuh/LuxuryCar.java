package com.iuh;

public class LuxuryCar  extends CarDecorator{

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        car.assemble();
        System.out.print(" Thiết kế đẹp mắt.");
    }
}
