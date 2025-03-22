package com.iuh;

public interface Observer {
//    public void update();
    public void setSubject(Subject sub);

    void update(String message);
}
