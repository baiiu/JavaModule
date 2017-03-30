package com.example.samples;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: baiiu
 * date: on 17/3/29 16:42
 * description: 线程交替打出1、2、3..
 * 线程1： 1、2、3
 * 线程2： 4、5、6
 * 线程1： 7、8、9
 * 线程2： 10、11、12
 * ...
 */
public class PrintCountMore {
    private int count = 1;
    private int n;

    private Lock lock = new ReentrantLock();
    private Condition condition_one = lock.newCondition();
    private Condition condition_two = lock.newCondition();

    void print123() {
        lock.lock();

        try {
            while (true) {
                Thread.sleep(10);

                while (count >= 4 + 6 * n && count <= 6 + 6 * n) {
                    condition_one.await();
                }

                while (count >= 1 + 6 * n && count <= 3 + 6 * n) {
                    System.out.println(Thread.currentThread().getName() + " --> " + count);
                    count++;
                }

                condition_two.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print456() {
        lock.lock();

        try {
            while (true) {
                Thread.sleep(10);

                while (count >= 1 + 6 * n && count <= 3 + 6 * n) {
                    condition_two.await();
                }

                while (count >= 4 + 6 * n && count <= 6 + 6 * n) {
                    System.out.println(Thread.currentThread().getName() + " --> " + count);
                    count++;
                }

                condition_one.signal();

                ++n;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
