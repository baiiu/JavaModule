package com.example.deadlock;

/**
 * auther: baiiu
 * time: 17/3/28 28 06:49
 * description: 死锁，多个线程互相持有对方的锁对象
 */
public class TestDeadLock {

    public static void main(String[] args) {
        Thread thread = new Thread(new DeadLockRunnable(false));
        Thread thread1 = new Thread(new DeadLockRunnable(true));

        thread.start();
        thread1.start();
    }
}
