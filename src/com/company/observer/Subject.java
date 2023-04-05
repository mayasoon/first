package com.company.observer;

import java.util.ArrayList;
import java.util.List;

//观察者模式，被订阅的主题，包含订阅着集合
public class Subject {

    private int anyThing;//随便一个主题
    List<Observer> observerList;

    public Subject() {
        observerList = new ArrayList<>();
    }

    /**
     * 添加订阅着
     * @param observer 订阅着
     */
    public void attach(Observer observer){
        observerList.add(observer);
    }

    /**
     * 通知订阅着被订阅主题发生变化
     * @param anyThing 变化的主题
     */
    public void setAnyThing(int anyThing) {
        this.anyThing = anyThing;
        notifyAllObservers();
    }
    
    public void notifyAllObservers(){
        for (Observer observer:observerList) {
            observer.update(anyThing);
        }
    }

}
