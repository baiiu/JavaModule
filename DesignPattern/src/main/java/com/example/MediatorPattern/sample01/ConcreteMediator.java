package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:54
 * description:
 */
class ConcreteMediator extends Mediator {
    //维持对各个同事对象的引用
    Button addButton;
    List list;
    TextBox userNameTextBox;
    ComboBox cb;

    //封装同事对象之间的交互
    public void componentChanged(Component c) {
        //单击按钮
        if (c == addButton) {
            System.out.println("--单击增加按钮--");
            list.update();
            cb.update();
            userNameTextBox.update();
        }
        //从列表框选择客户
        else if (c == list) {
            System.out.println("--从列表框选择客户--");
            list.select();
            cb.select();
            userNameTextBox.setText();
        }
        //从组合框选择客户
        else if (c == cb) {
            System.out.println("--从组合框选择客户--");
            list.select();
            cb.select();
            userNameTextBox.setText();
        }
    }
}
