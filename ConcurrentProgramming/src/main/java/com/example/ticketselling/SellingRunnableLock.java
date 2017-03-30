package com.example.ticketselling;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: baiiu
 * date: on 17/3/26 12:48
 * description:
 */
class SellingRunnableLock implements Runnable {

    private final Lock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {
        lock.lock();

        try {
            while (true) {
                Thread.sleep(10);

                if (ticket == 0) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " --> " + ticket);
                --ticket; //这是一个非原子操作，不能放在第一句

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
