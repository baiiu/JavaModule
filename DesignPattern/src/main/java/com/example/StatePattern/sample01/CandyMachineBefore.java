package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:28
 * description:
 * 1.存在大量的switch case 语句 当然可以用if else 也是一样的。
 * 2.可扩展性差，并且一旦要加入一种新的状态，那么就会要修改所有的switch case 不符合开闭原则
 * 3.没有采用面向对象的方式去封装
 * <p>
 * 可以采用状态模式
 */
public class CandyMachineBefore {
    private final static int SoldOutState = 0; //初始状态
    private final static int OnReadyState = 1; //待机状态
    private final static int HasCoin = 2; //准备状态
    private final static int SoldState = 3; //售出状态

    private int state = SoldOutState; //变量,用于存放当前的状态值
    private int count; //糖果的数目

    public CandyMachineBefore(int count) {
        this.count = count;
        if (count > 0) {
            state = OnReadyState;
        }
    }

    //投入硬币行为的时候，通过判断当前的状态来匹配所有的状态.
    public void insertCoin() {
        switch (state) {
            case SoldOutState:
                System.out.println("you can't insert coin,the machine sold out!");
                break;
            case OnReadyState: //只有在待机状态的时候,投入硬币行为正确,并将状态改变为准备状态
                state = HasCoin;
                System.out.println("you have inserted a coin,next,please turn crank!");
                break;
            case HasCoin:
                System.out.println("you can't insert another coin!");
                break;
            case SoldState:
                System.out.println("please wait!we are giving you a candy!");
                break;
        }

    }

    //回退硬币
    public void returnCoin() {
        switch (state) {
            case SoldOutState:
                System.out.println("you can't return,you haven't inserted a coin yet!");
                break;
            case OnReadyState:
                System.out.println("you haven't inserted a coin yet!");
                break;
            case HasCoin:
                System.out.println("coin return!");
                state = OnReadyState;
                break;
            case SoldState:
                System.out.println("sorry,you already have turned the crank!");
                break;
        }
    }

    // 转动曲柄
    public void turnCrank() {
        switch (state) {
            case SoldOutState:
                System.out.println("you turned,but there are no candies!");
                break;
            case OnReadyState:
                System.out.println("you turned,but you haven't inserted a coin!");
                break;
            case HasCoin:
                System.out.println("crank turn...!");
                state = SoldState;
                dispense();
                break;
            case SoldState:
                System.out.println("we are giving you a candy,turning another get nothing,!");
                break;
        }
    }

    // 触发发放糖果行为
    private void dispense() {
        count = count - 1;
        System.out.println("a candy rolling out!");
        if (count > 0) {
            state = OnReadyState;
        } else {
            System.out.println("Oo,out of candies");
            state = SoldOutState;
        }
    }

    public void printState() {
        switch (state) {
            case SoldOutState:
                System.out.println("***SoldOutState***");
                break;
            case OnReadyState:
                System.out.println("***OnReadyState***");
                break;
            case HasCoin:

                System.out.println("***HasCoin***");

                break;
            case SoldState:
                System.out.println("***SoldState***");
                break;
        }
    }
}

