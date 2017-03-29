package com.example.consumersAndProducersLock;

/**
 * auther: baiiu
 * time: 17/3/29 29 06:52
 * description:
 */
public class TestLock {

    public static void main(String[] args) {
        Resource r = new Resource();

        Consumer consumer = new Consumer(r);
        Producer producer = new Producer(r);

        Thread t1 = new Thread(consumer);
        Thread t2 = new Thread(consumer);

        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(producer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
