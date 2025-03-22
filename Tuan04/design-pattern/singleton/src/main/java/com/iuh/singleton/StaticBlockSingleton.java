package com.iuh.singleton;

// cách 2 để tạo ra singleton
public class StaticBlockSingleton {

    //B3:
    private static StaticBlockSingleton instance;

    //B1: Tạo constructor
    private StaticBlockSingleton(){

    }

    //B4: khối static
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    //B2: tạo getInstance
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}