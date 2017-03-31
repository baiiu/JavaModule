package com.example.deadLockBetter;

/**
 * author: baiiu
 * date: on 17/3/30 17:31
 * description:
 */
class DeadLockRunnable implements Runnable {
    private final Object objA;
    private final Object objB;

    DeadLockRunnable(Object objA, Object objB) {
        this.objA = objA;
        this.objB = objB;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (objA) {
                System.out.println(Thread.currentThread().getName() + " -->  " + objA);

                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + " --> " + objB);
                }
            }

        }
    }
}
