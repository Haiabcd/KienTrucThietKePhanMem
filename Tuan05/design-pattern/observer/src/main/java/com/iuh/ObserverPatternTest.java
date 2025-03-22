package com.iuh;

public class ObserverPatternTest {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();

        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");
        Observer obj4 = new MyTopicSubscriber("Obj4");

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        topic.register(obj4);

        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);
        obj4.setSubject(topic);

        topic.postMessage("Xin chào, this is new bug");

 /*
        new Thread(() -> topic.register(obj1)).start();
        new Thread(() -> topic.register(obj2)).start();
        new Thread(() -> topic.register(obj3)).start();

        new Thread(() -> topic.postMessage("Message 1")).start();
        new Thread(() -> topic.postMessage("Message 2")).start();
        new Thread(() -> topic.postMessage("Message 3")).start();

  */
    }
}