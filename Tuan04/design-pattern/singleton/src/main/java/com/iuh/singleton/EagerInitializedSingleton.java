package com.iuh.singleton;

// cách 1 để tạo ra singleton
public class EagerInitializedSingleton {
    //B3 : Tạo biến final để cuôi cùng
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // B1: contructor là private
    private EagerInitializedSingleton(){

    }
    // B2: tạo method để truy xuất được instance đó
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
