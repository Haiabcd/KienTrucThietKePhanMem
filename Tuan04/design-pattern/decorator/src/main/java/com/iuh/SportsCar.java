package com.iuh;

public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        car.assemble(); //lay lai het tinh nang cu
        System.out.print(" Chạy siêu nhanh.");  //them tinh nang moi
    }
}