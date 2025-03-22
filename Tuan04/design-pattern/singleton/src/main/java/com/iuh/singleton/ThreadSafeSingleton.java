package com.iuh.singleton;

// cách 4 để tạo ra singleton: thích hợp cho môi trường đa luồng
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    // B1: tạo constructor private
    private ThreadSafeSingleton(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //B2: tạo getInstance (cach 1)
//    public static synchronized ThreadSafeSingleton getInstance(){
//        if(instance == null){
//            instance = new ThreadSafeSingleton();
//        }
//        return instance;
//    }
     //B2: tạo getInstance (cach 2) ==> thi dung nay
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){  // Kiểm tra lần 1 (tránh tốn tài nguyên nếu instance đã tồn tại)
            synchronized (ThreadSafeSingleton.class) { // Chỉ khóa khi instance chưa tồn tại
                if(instance == null){ // Kiểm tra lần 2 (đảm bảo chỉ tạo 1 instance)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

