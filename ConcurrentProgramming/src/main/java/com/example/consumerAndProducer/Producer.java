package com.example.consumerAndProducer;

/**
 * auther: baiiu
 * time: 17/3/28 28 22:52
 * description:
 */
class Producer implements Runnable {
    Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce("烤鸭");
        }
    }
}
