package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:56
 * description:
 */
class ComboBox extends Component {
    ComboBox(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("组合框增加一项：张无忌。");
    }

    void select() {
        System.out.println("组合框选中项：小龙女。");
    }
}
