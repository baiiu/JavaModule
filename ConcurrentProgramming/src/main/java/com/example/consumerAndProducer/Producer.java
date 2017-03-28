package com.example.consumerAndProducer;

/**
 * author: baiiu
 * date: on 17/3/28 10:15
 * description:
 */
class Producer implements Runnable {
    private Resource resource;

    Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (resource) {

                int produce = resource.produce();
                if (produce > 100) {
                    //不能生产大于100个
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " --> " + produce);
            }

        }
    }

}
