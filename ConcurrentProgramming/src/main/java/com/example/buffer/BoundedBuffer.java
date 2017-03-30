package com.example.buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: baiiu
 * date: on 17/3/29 18:34
 * description:
 */
class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition condition_put = lock.newCondition();
    private final Condition condition_take = lock.newCondition();

    private final Object[] items = new Object[100];
    private int putptr, takeptr, count;

    void put(Object x) {
        lock.lock();
        try {
            while (count == items.length) {
                condition_put.await();
            }

            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            condition_take.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public Object take() {
        lock.lock();
        try {
            while (count == 0) {
                condition_take.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            condition_put.signal();
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;
    }
}