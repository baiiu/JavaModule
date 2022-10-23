package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 22:12
 * description:
 */
class ZZMainTest {
    public static void main(String[] args) {
        //定义中介者对象
        ConcreteMediator mediator = new ConcreteMediator();

        //定义同事对象
        Button addBT = new Button(mediator);
        List list = new List(mediator);
        ComboBox cb = new ComboBox(mediator);
        TextBox userNameTB = new TextBox(mediator);

        mediator.addButton = addBT;
        mediator.list = list;
        mediator.cb = cb;
        mediator.userNameTextBox = userNameTB;

        addBT.changed();
        System.out.println("-----------------------------");
        list.changed();
    }
}
