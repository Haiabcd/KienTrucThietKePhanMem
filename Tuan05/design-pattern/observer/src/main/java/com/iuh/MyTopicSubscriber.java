package com.iuh;

public class MyTopicSubscriber implements Observer {
    private final String name;
    private Subject topic;


    public MyTopicSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update(String message) {
//        String msg = (String) topic.getUpdate(this);
//        if (msg == null) {
//            System.out.println(name + ":: No new message");
//        } else
//            System.out.println(name + ":: Consuming message::" + msg);

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
