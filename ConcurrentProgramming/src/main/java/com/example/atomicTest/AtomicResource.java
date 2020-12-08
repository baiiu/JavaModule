package com.example.atomicTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: baiiu
 * time: 2020/12/8
 * description:
 */
public class AtomicResource {

    private final AtomicInteger number = new AtomicInteger(0);

    public int getNumber() {
        return number.getAndSet(0);
    }

    public void increment() {
        this.number.getAndIncrement();
    }
}
