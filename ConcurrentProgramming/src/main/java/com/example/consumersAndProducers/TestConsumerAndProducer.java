package com.example.consumersAndProducers;

/**
 * author: baiiu
 * date: on 17/3/28 10:13
 * description:
 */
public class TestConsumerAndProducer {

    public static void main(String[] args) {
        Resource resource = new Resource();

        Consumer consumer = new Consumer(resource);
        Producer producer = new Producer(resource);

        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);

        Thread producerThread1 = new Thread(producer);
        Thread producerThread2 = new Thread(producer);

        consumerThread1.start();
        consumerThread2.start();

        producerThread1.start();
        producerThread2.start();
    }

}
