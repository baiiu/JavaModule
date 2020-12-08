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
        // 不安全
//        int i = number.get();
//        number.set(0);
//        return i;

        // 安全
        return number.getAndSet(0);
    }

    public void increment() {
        this.number.getAndIncrement();
    }
}
