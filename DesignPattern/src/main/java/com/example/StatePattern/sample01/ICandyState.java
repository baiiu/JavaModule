package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:21
 * description:
 */
interface ICandyState {
    /**
     * 投入硬币行为
     */
    void insertCoin();

    /**
     * 回退硬币行为
     */
    void returnCoin();

    /**
     * 转动曲柄行为
     */
    void turnCrank();

    /**
     * 触发发放糖果行为
     */
    void dispense();

    void printState();
}
