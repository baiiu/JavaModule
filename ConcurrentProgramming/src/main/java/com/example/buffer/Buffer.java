package com.example.buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: baiiu
 * date: on 17/3/29 17:06
 * description:
 */
class Buffer {

    private Object[] array = new Object[100];
    private int count;//当前元素个数
    private int takePtr;//获取的指针
    private int putPtr;//存入的指针

    private Lock lock = new ReentrantLock();
    private Condition condition_put = lock.newCondition();
    private Condition condition_take = lock.newCondition();

    void put(Object o) {
        lock.lock();

        try {
            while (count == array.length) {
                //存满了
                condition_put.await();//当前线程等待，而不是这个锁；两个锁条件所指的都是同一个锁
            }

            if (o == null) {
                return;
            }


            array[putPtr] = o;
            if (++putPtr == array.length) {
                putPtr = 0;
            }

            ++count;
            condition_take.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Object take() {
        lock.lock();

        try {
            while (count == 0) {
                condition_take.await(); // t0等待
            }

            Object o = array[takePtr];
            if (++takePtr == array.length) {
                takePtr = 0;
            }

            --count;
            condition_put.signal();

            return o;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;

    }


}
