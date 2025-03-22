package com.iuh.singleton;

// cách 3 để tạo ra singleton: thích hợp cho môi trường đơn luồng
public class LazyInitializedSingleton {
    //B3:
    private static LazyInitializedSingleton instance;


    //B1: Tạo constructor
    private LazyInitializedSingleton(){

    }

    //B2: tạo getInstance
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

// khắc phục 2 loại đầu: chỉ khi nào gọi getInstance thì mới được khởi tạo