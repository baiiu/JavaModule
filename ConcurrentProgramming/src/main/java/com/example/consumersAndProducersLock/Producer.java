package com.example.consumersAndProducersLock;

/**
 * auther: baiiu
 * time: 17/3/29 29 06:51
 * description:
 */
class Producer implements Runnable {
    Resource r;

    public Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.produce();
        }
    }
}
