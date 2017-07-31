package com.example.ticketselling;

/**
 * auther: baiiu
 * time: 17/4/1 01 21:47
 * description:
 */
class SellingThread extends Thread {
    private static int ticket = 100;

    private boolean flag;

    SellingThread(boolean b) {
        this.flag = b;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (SellingThread.class) {
//                if (!flag) {
//                    //不起作用
//                    Thread.yield();
//                }
                if(flag){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                if (ticket == 0) {
                    break;
                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                System.out.println(Thread.currentThread().getName() + " --> " + ticket);

                --ticket; //这是一个非原子操作，不能放在第一句
            }

        }
    }
}
