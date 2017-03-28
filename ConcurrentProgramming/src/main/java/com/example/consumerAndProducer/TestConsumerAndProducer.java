package com.example.consumerAndProducer;

/**
 * author: baiiu
 * date: on 17/3/28 10:13
 * description:
 */
public class TestConsumerAndProducer {

    public static void main(String[] args) {
        Resource resource = new Resource(100);

        Consumer consumer = new Consumer(resource);
        Producer producer = new Producer(resource);

        Thread consumerThread = new Thread(consumer, "消费者");
        Thread producerThread = new Thread(producer, "生产者");

        consumerThread.start();
        producerThread.start();

    }

}
