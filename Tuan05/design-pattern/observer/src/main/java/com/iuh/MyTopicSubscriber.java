package com.iuh;

public class MyTopicSubscriber implements Observer {
    private final String name;
    private Subject topic;


    public MyTopicSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update(String message) {

        if (message == null) {
            System.out.println(name + ":: No new message");
        } else {
            System.out.println(name + ":: Consuming message::" + message);
        }
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
}
