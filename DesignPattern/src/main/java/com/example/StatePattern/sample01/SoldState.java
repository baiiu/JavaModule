package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:24
 * description:
 */
public class SoldState implements State {
    private CandyMachine mCandyMachine;

    SoldState(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("please wait!we are giving you a candy!");
    }

    @Override
    public void returnCoin() {
        System.out.println("you haven't inserted a coin yet!");
    }

    @Override
    public void turnCrank() {
        System.out.println("we are giving you a candy,turning another get nothing,!");
    }

    @Override
    public void dispense() {
        mCandyMachine.releaseCandy();
        if (mCandyMachine.getCount() > 0) {
            mCandyMachine.setState(mCandyMachine.mOnReadyState);
        } else {
            System.out.println("Oo,out of candies");
            mCandyMachine.setState(mCandyMachine.mSoldOutState);
        }
    }

    @Override
    public void printstate() {
        System.out.println("***SoldState***");
    }

}
