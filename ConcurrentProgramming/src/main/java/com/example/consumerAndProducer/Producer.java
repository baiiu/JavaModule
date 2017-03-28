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

                //生产好了，就等待消费
                if (resource.flag) {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //没生产好，持续生产
                int produce = resource.produce();
                System.out.println(Thread.currentThread().getName() + " --> " + produce);

                if (produce > 100) {
                    resource.flag = true;
                    resource.notify();
                }

            }

        }
    }

}
