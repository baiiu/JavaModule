package com.example.deadLockBetter;

/**
 * author: baiiu
 * date: on 17/3/30 17:34
 * description: 两个线程互相持有对方锁
 */
class Test {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        new Thread(new DeadLockRunnable(objA, objB)).start();
        new Thread(new DeadLockRunnable(objB, objA)).start();
    }
}
