package com.example.ObserverPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 23:13
 * description:
 */
class ConcreteAllyControlCenter extends AllyControlCenter {

    ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组建成功！");
        System.out.println("----------------------------");
        this.allyName = allyName;
    }

    //实现通知方法
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
        //遍历观察者集合，调用每一个盟友（自己除外）的支援方法
        for (Observer player : players) {
            if (!player.getName().equalsIgnoreCase(name)) {
                player.help();
            }
        }

    }
}
