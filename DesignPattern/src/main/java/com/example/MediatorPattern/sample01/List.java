package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:55
 * description:
 */
class List extends Component {
    List(ConcreteMediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("列表框增加一项：张无忌。");
    }

    void select() {
        System.out.println("列表框选中项：小龙女。");
    }
}
