package com.iuh;

public class TaxValueAdded extends TaxDecorator{
    public TaxValueAdded(Tax tax) {
        super(tax);
    }

    @Override
    public void taxCalculation(){
        super.taxCalculation();
        System.out.print("Thuế Gía Trị Gia Tăng ");
    }
}
