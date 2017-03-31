package com.example.deadlock;

/**
 * auther: baiiu
 * time: 17/3/28 28 06:39
 * description:
 */

class DeadLockRunnable implements Runnable {
    private static final Object objA = new Object();
    private static final Object objB = new Object();

    private boolean flag;

    DeadLockRunnable(boolean flag) {
        this.flag = flag;
    }

    @Override public void run() {
        if (flag) {
            synchronized (objA) {
                System.out.println("if objA");
                synchronized (objB) {
                    System.out.println("if objB");
                }
            }

        } else {
            synchronized (objB) {
                System.out.println("else objB");
                synchronized (objA) {
                    System.out.println("else objA");
                }
            }
        }


    }

}
