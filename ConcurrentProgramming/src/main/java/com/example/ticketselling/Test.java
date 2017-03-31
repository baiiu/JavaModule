package com.example.ticketselling;

/**
 * author: baiiu
 * date: on 17/3/26 12:47
 * description: 多线程同步问题： 多个线程共用一把锁
 */
public class Test {

    public static void main(String[] args) {

//      Runnable runnable = new SellingRunnable();
//        Runnable runnable = new SellingRunnableLock();
        Runnable runnable = new SellingRunnableAtomic();

        Thread thread1 = new Thread(runnable, "窗口1");
        Thread thread2 = new Thread(runnable, "窗口2");
        Thread thread3 = new Thread(runnable, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
