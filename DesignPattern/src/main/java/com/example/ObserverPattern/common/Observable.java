package com.example.ObserverPattern.common;

import java.util.ArrayList;
import java.util.Observer;

/**
 * auther: baiiu
 * time: 18/12/20 20 22:32
 * description:
 */
abstract class Observable {
    private ArrayList<Observer> mObservers = new ArrayList();

    public void regist(Observer observer) {
        mObservers.add(observer);
    }

    public void unregist(Observer observer) {
        mObservers.remove(observer);
    }

    //声明抽象通知方法
    public abstract void notifyObservers();
}
