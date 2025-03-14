package com.iuh;

public class TaxTest {
    public static void main(String[] args) {
        Tax tax01 = new TaxSpecial(new TaxConsumption(new TaxValueAdded(new TaxBasic())));
        tax01.taxCalculation();

        System.out.println("");

        Tax tax02 = new TaxSpecial(new TaxConsumption(new TaxBasic()));
        tax02.taxCalculation();
    }
}
