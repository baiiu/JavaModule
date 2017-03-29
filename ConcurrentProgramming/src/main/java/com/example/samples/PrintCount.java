package com.example.samples;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * auther: baiiu
 * time: 17/3/29 29 07:45
 * description:
 */
class PrintCount {
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition reachThreeCondition = lock.newCondition();//到3了么
    private Condition reachSixCondition = lock.newCondition();//到6了么

    void print() {
        lock.lock();

        try {
            while (count <= 3) {
                ++count;
                System.out.println(Thread.currentThread().getName() + " --> " + count);
            }

            reachThreeCondition.await();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
