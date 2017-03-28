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

                int consume = resource.consume();
                if (consume == 0) {
                    //消费完了，去生产

                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " --> " + consume);

            }
        }

    }

}
