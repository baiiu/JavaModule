package com.example.MediatorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 21:55
 * description:
 */
class Button extends Component {

    public Button(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void update() {
        //按钮不产生交互
    }

}
