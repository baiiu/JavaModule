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
    private int count = 1;

    private Lock lock = new ReentrantLock();
    private Condition reachThreeCondition = lock.newCondition();//到3了么
    private Condition reachSixCondition = lock.newCondition();//到6了么

    void print123() {
        lock.lock();

        try {
            while (count <= 3) {
                System.out.println(Thread.currentThread().getName() + " --> " + count);
                ++count;
            }

            reachThreeCondition.signal();
        } finally {
            lock.unlock();
        }

        lock.lock();
        try {
//            while (count <= 6) {
            reachSixCondition.await();
//            }

            while (count <= 9) {
                System.out.println(Thread.currentThread().getName() + " --> " + count);
                ++count;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

//    void print789() {
//        lock.lock();
//
//        try {
////            while (count <= 6) {
//            reachSixCondition.await();
////            }
//
//            while (count <= 9) {
//                System.out.println(Thread.currentThread().getName() + " --> " + count);
//                ++count;
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//
//    }

    void print456() {
        lock.lock();

        try {
            while (count <= 3) {
                reachThreeCondition.await();
            }

            while (count <= 6) {
                System.out.println(Thread.currentThread().getName() + " --> " + count);
                ++count;
            }

            reachSixCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
