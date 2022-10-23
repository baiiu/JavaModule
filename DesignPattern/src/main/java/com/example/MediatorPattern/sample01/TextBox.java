package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:56
 * description:
 */
class TextBox extends Component {
    TextBox(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空。");
    }

    void setText() {
        System.out.println("文本框显示：小龙女。");
    }
}
