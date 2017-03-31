package com.example.ticketselling;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * auther: baiiu
 * time: 17/3/30 30 22:26
 * description: 这个代码是错误的，有多条语句在操作共享变量ticket
 */
class SellingRunnableAtomic implements Runnable {
    private volatile AtomicInteger ticket = new AtomicInteger(100);

    @Override
    public void run() {

        while (true) {


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             /*
                不能使用ticket.get() == 0来判断，举个例子：
                到1的时候，
                t0释放了锁，t0睡眠，
                导致t1线程进来了，t1进来，减了一个，为0，volatile保证该变量被可见
                t0醒来了，减了一个，变成-1，继续往下执行了
             */

            // 还是得用同步，这是多条语句在操作共享变量，哈哈，这个代码是错误的。留着当个教训

            if (ticket.get() <= 0) {
                break;
            }


            System.out.println(Thread.currentThread().getName() + " --> " + ticket.getAndDecrement());
        }


    }
}
