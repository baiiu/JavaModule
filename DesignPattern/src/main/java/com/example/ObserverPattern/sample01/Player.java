package com.example.ObserverPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 23:12
 * description:
 */
class Player extends Observer {
    private String name;

    Player(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    //支援盟友方法的实现
    void help() {
        System.out.println("坚持住，" + this.name + "来救你！");
    }

    //遭受攻击方法的实现，当遭受攻击时将调用战队控制中心类的通知方法notifyObserver()来通知盟友
    void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "被攻击！");
        acc.notifyObserver(name);
    }
}
