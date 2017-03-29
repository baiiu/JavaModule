package com.example.consumersAndProducersLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * auther: baiiu
 * time: 17/3/29 29 06:48
 * description:
 */
class Resource {

    private int count;
    private boolean flag;//生产好了么

    private Lock mLock = new ReentrantLock();
    //    private Condition mCondition = mLock.newCondition();

    /*
        一个锁上有多个监视器，不同的监视器监视不同的线程，控制不同的线程，但共享着一把锁
     */
    private Condition condition_con = mLock.newCondition();//控制消费者线程
    private Condition condition_pro = mLock.newCondition();//控制生产者线程

    void produce() {
        mLock.lock();
        try {
            while (flag) {
                //生产好了，等待消费
                condition_pro.await();
            }

            //生产
            ++count;
            System.out.println(Thread.currentThread().getName() + "生产--> " + count);
            flag = true;//生产好了，去消费吧
            condition_con.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }

    void consume() {
        mLock.lock();
        try {
            while (!flag) {
                //没生产好，等待生产
                condition_con.await();
            }

            //生产好了，消费
            System.out.println(Thread.currentThread().getName() + "消费---> " + count);
            flag = false;//消费完了，去生产吧
            condition_pro.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }


    }

}
