package com.example.StatePattern.sample03;

/**
 * auther: baiiu
 * time: 18/12/21 21 07:47
 * description: https://www.jianshu.com/p/f2668fcaba87
 * <p>
 * 电视有开和关两种状态，有调音量，换台，开机，关机等行为，
 * 当电视处于关闭状态，只会响应开机指令，而电视处于打开状态，则会响应调音量，换台，关机的指令。
 */
class ZZMainClass {
    public static void main(String[] args) {
        TvController tvController = new TvController();
        tvController.powerOn();
        tvController.nextChannel();
        tvController.turnUp();
        tvController.powerOff();
        //调高音量，此时不会生效
        tvController.turnUp();
    }
}
