package com.example.consumerAndProducer;

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

        Thread consumerThread1 = new Thread(consumer, "1号消费");
        Thread consumerThread2 = new Thread(consumer, "2号消费");

        Thread producerThread1 = new Thread(producer, "1号生产");
        Thread producerThread2 = new Thread(producer, "2号生产");

        consumerThread1.start();
        consumerThread2.start();

        producerThread1.start();
        producerThread2.start();
    }

}
