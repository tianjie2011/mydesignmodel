package com.example.mydesignmodel.observer;

public class MyTopicSubscriber implements MyObserver{

    private String name;
    private MySubject topic;

    public MyTopicSubscriber(String name) {
        this.name=name;
    }


    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);

        if(msg == null){

            System.out.println(name+":: No new message");

        }else

        System.out.println(name+":: Consuming message::"+msg);

    }

    @Override
    public void setSubject(MySubject sub) {
        this.topic=sub;
    }
}
