package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:22
 * description:
 */
public class OnReadyState implements ICandyState {
    private CandyMachine mCandyMachine;

    OnReadyState(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you have inserted a coin,next,please turn crank!");
        mCandyMachine.setState(mCandyMachine.mHasCoin);
    }

    @Override
    public void returnCoin() {
        System.out.println("you haven't inserted a coin yet!");

    }

    @Override
    public void turnCrank() {

        System.out.println("you turned,but you haven't inserted a coin!");

    }

    @Override
    public void dispense() {


    }

    @Override
    public void printState() {
        System.out.println("***OnReadyState***");
    }

}
