package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:23
 * description:
 */
public class SoldOutState implements State {

    private CandyMachine mCandyMachine;

    SoldOutState(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you can't insert coin,the machine sold out!");

    }

    @Override
    public void returnCoin() {
        System.out.println("you can't return,you haven't inserted a coin yet!");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned,but there are no candies!");
    }

    @Override
    public void dispense() {

    }

    @Override
    public void printstate() {
        System.out.println("***SoldOutState***");
    }

}
