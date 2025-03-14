package com.iuh;

public class TaxConsumption extends TaxDecorator{
    public TaxConsumption(Tax tax) {
        super(tax);
    }

    @Override
    public void taxCalculation(){
        super.taxCalculation();
        System.out.print("Thuế Tiêu Thụ ");
    }
}
