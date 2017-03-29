package com.example.consumersAndProducersLock;

/**
 * auther: baiiu
 * time: 17/3/29 29 06:50
 * description:
 */
class Consumer implements Runnable {
    Resource r;

    public Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.consume();
        }
    }
}
