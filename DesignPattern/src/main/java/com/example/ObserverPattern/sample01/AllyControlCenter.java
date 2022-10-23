package com.example.ObserverPattern.sample01;

import java.util.ArrayList;

/**
 * auther: baiiu
 * time: 18/12/20 20 23:12
 * description:
 */
abstract class AllyControlCenter {
    String allyName; //战队名称
    ArrayList<Observer> players = new ArrayList<Observer>(); //定义一个集合用于存储战队成员

    void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    String getAllyName() {
        return this.allyName;
    }

    //注册方法
    void join(Observer obs) {
        System.out.println(obs.getName() + "加入" + this.allyName + "战队！");
        players.add(obs);
    }

    //注销方法
    void quit(Observer obs) {
        System.out.println(obs.getName() + "退出" + this.allyName + "战队！");
        players.remove(obs);
    }

    //声明抽象通知方法
    abstract void notifyObserver(String name);
}
