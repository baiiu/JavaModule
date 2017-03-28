package com.example.consumerAndProducer;

/**
 * author: baiiu
 * date: on 17/3/28 10:15
 * description:
 */
class Consumer implements Runnable {
    private Resource resource;

    Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (resource) {
                if (!resource.flag) {
                    //没生产好，就等待
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                //生产好了，就消费
                int consume = resource.consume();
                System.out.println(Thread.currentThread().getName() + " --> " + consume);

                if (consume == 0) {
                    resource.flag = false; //消费完了，去生产
                    resource.notify();
                }

            }
        }

    }

}
