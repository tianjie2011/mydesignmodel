package com.example.mydesignmodel.observer;


import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MyTopic implements MySubject {


    private List<MyObserver> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();

    }

    @Override
    public void register(MyObserver  obj) {
        if (obj == null) throw new NullPointerException("Null Observer");

        if (!observers.contains(obj)) observers.add(obj);

    }

    @Override
    public void unregister(MyObserver obj) {
        observers.remove(obj);

    }




    @Override
    public void notifyObservers() {
        List<MyObserver> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (MyObserver obj : observersLocal) {
            obj.update();
        }
    }


    @Override
    public Object getUpdate(MyObserver obj) {
        return this.message;

    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();

    }
}