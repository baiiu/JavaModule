package com.example.ticketselling;

/**
 * author: baiiu
 * date: on 17/3/26 12:48
 * description:
 */
class SellingRunnable implements Runnable {

    private int ticket = 100; //volatile不能保证原子性，必须使用同步，synchronized或lock


    @Override
    public void run() {
        while (true) {

            synchronized (this) {

                if (ticket == 0) {
                    break;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(Thread.currentThread().getName() + " --> " + ticket);

                --ticket; //这是一个非原子操作，不能放在第一句
            }

        }
    }
}
