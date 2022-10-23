package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:50
 * description: 抽象组件类：抽象同事类
 */
abstract class Component {
    private Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    //转发调用
    void changed() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}
