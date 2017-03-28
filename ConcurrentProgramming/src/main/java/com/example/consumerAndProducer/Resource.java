package com.example.consumerAndProducer;

/**
 * auther: baiiu
 * time: 17/3/28 28 22:44
 * description:
 * 生产者 生产 x 号
 * 消费者 消费 x 号
 * <p>
 * 生产一只消费一只
 */
class Resource {

    private String name;
    private int count;

    private boolean flag;//生产好了么

    synchronized void produce(String name) {
        while (flag) {
            //生产好了，等待消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name + count;
        count++;

        System.out.println(Thread.currentThread().getName() + "--> " + this.name);
        flag = true;//生产好了
        this.notifyAll();

    }

    synchronized void consumer() {
        while (!flag) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //生产好了，消费
        System.out.println(Thread.currentThread().getName() + "----> " + this.name);
        flag = false;
        this.notifyAll();

    }


}
