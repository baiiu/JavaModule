package com.example.consumerAndProducer;

/**
 * auther: baiiu
 * time: 17/3/28 28 22:54
 * description:
 */
class Consumer implements Runnable {
    Resource r;

    Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consumer();
        }
    }
}
