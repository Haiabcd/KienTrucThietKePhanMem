package com.iuh;

public class TaxDecorator implements Tax{
    protected Tax tax;

    public TaxDecorator(Tax tax) {
        this.tax = tax;
    }

    @Override
    public void taxCalculation() {
        this.tax.taxCalculation();
    }
}
