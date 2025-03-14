package com.iuh;

public class TaxSpecial extends TaxDecorator{
    public TaxSpecial(Tax tax) {
        super(tax);
    }

    @Override
    public void taxCalculation(){
        super.taxCalculation();
        System.out.print("Thuế Đặc Biệt ");
    }
}
