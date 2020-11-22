package com.example.mydesignmodel.observer;

import java.util.Observer;

public interface MySubject {
    public void register(MyObserver obj);
    public void unregister(MyObserver obj);

    public void notifyObservers();

    public Object getUpdate(MyObserver obj);

}
