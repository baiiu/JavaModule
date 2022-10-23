package com.example.ObserverPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 23:11
 * description:
 */
abstract class Observer {
    abstract String getName();

    abstract void setName(String name);

    abstract void help(); //声明支援盟友方法

    abstract void beAttacked(AllyControlCenter acc);
}
