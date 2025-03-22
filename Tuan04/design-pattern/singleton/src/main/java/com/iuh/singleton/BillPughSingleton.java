package com.iuh.singleton;

// cách 5 để tạo ra singleton: không yêu cầu gì, sử dụng cách này
public class BillPughSingleton {

    //B1: Tạo constructor
    private BillPughSingleton(){

    }

    //B2: tạo static NESTED CLASS
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    //B3: tạo phuong thuc
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

//
