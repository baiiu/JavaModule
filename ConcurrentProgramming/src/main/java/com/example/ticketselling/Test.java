package com.example.ticketselling;

/**
 * author: baiiu
 * date: on 17/3/26 12:47
 * description:
 */

public class Test {

    public static void main(String[] args) {

        SellingRunnable runnable = new SellingRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
