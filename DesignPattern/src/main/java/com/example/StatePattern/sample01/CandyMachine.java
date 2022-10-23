package com.example.StatePattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/21 21 08:25
 * description:
 */
class CandyMachine {
    ICandyState mSoldOutState;
    ICandyState mOnReadyState;
    ICandyState mHasCoin;
    ICandyState mSoldState;
    ICandyState mWinnerState;
    private ICandyState state;
    private int count = 0;

    CandyMachine(int count) {
        this.count = count;
        mSoldOutState = new SoldOutState(this);
        mOnReadyState = new OnReadyState(this);
        mHasCoin = new HasCoin(this);
        mSoldState = new SoldState(this);
        mWinnerState = new WinnerState(this);
        if (count > 0) {
            state = mOnReadyState;
        } else {
            state = mSoldOutState;
        }
    }

    void setState(ICandyState state) {
        this.state = state;
    }

    void insertCoin() {
        state.insertCoin();
    }

    void returnCoin() {
        state.returnCoin();
    }

    void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseCandy() {

// TODO Auto-generated method stub
        if (count > 0) {
            count = count - 1;
            System.out.println("a candy rolling out!");
        }

    }

    int getCount() {
        return count;
    }

    void printstate() {
        state.printState();
    }
}
