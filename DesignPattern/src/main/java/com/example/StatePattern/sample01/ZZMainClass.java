package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 07:47
 * description:
 * [状态模式](http://www.importnew.com/26627.html)
 */
class ZZMainClass {
    public static void main(String[] args) {
        CandyMachine mCandyMachine = new CandyMachine(6);

        mCandyMachine.printstate();

        mCandyMachine.insertCoin();
        mCandyMachine.printstate();

        mCandyMachine.turnCrank();

        mCandyMachine.printstate();

        mCandyMachine.insertCoin();
        mCandyMachine.printstate();

        mCandyMachine.turnCrank();

        mCandyMachine.printstate();
    }
}
