package com.iuh;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private final List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object(); // dam bao rang khong co 2 luong nao cung thao tac voi 1 Topic

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    // khong su dung
    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null; // tao ra danh sach nguoi dang ky moi nhung rong
      synchronized (MUTEX) {
            if (!changed) // changed == false --> khong can thong bao, return
                return;
            observersLocal = new ArrayList<>(this.observers);//changed == true --> copy danh sach nguoi theo doi cua minh vao danh sach rong ơ tren
            this.changed = false; // cap nhat chaged
      }
        for (Observer obj : observersLocal) {
            obj.update(this.message);
        }
    }

    public void postMessage (String msg){
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}
