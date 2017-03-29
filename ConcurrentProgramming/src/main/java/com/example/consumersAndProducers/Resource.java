package com.example.consumersAndProducers;

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

    private int count;

    private boolean flag;//生产好了么

    synchronized void produce() {
        while (flag) { //用while循环，唤醒本方线程时再次判断标记，不会往下走
            //生产好了，等待消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;

        System.out.println(Thread.currentThread().getName() + "生产--> " + this.count);
        flag = true;//生产好了
        this.notifyAll();//避免只唤醒本方线程，造成所有本方线程进入wait状态

    }

    synchronized void consumer() {
        while (!flag) {
            //没生产好，等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //生产好了，消费
        System.out.println(Thread.currentThread().getName() + "消费---> " + this.count);
        flag = false;
        this.notifyAll();

    }


}
