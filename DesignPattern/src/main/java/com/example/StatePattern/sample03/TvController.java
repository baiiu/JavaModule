package com.example.StatePattern.sample03;

public class TvController {
    TvState mTvState;

    public void setTvState(TvState tvState) {
        mTvState = tvState;
    }

    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void prevChannel() {
        mTvState.prevChannel();
    }

    public void turnUp() {
        mTvState.turnUp();
    }

    public void turnDown() {
        mTvState.turnDown();
    }
}

