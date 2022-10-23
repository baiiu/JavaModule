package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:21
 * description:
 */
interface State {
    void insertCoin();

    void returnCoin();

    void turnCrank();

    void dispense();

    void printstate();
}
