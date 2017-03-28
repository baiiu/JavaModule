package com.example.ticketselling;

/**
 * author: baiiu
 * date: on 17/3/26 12:48
 * description:
 */
class SellingRunnable implements Runnable {

    /*
    volatile有两个语义：可见性与读写原子性。
    a在写变量的过程中，b是无法读取的。因为CPU会锁定这块内存区域的缓存并回写到内存，此时B才可以读取。
    如果A在写的过程中B可以读取，那么线程B读取的是脏数据。

    i++之所以无法用volatile保证原子性。是因为volatile仅仅保证读取加锁，而对于中间的加1操作是不会加锁的。线程B如果在这个期间读取值，那肯定会是脏数据。


    Java 规定，
    （1）当一个线程要使用共享内存中的 volatile 变量时，如图中的变量a，它会直接从主内存中读取，而不使用自己本地内存中的副本。
    （2）当一个线程对一个 volatile 变量进行写时，它会将这个共享变量的值刷新到共享内存中。

    volatile 变量保证的是一个线程对它的写会立即刷新到主内存中，并置其它线程的副本为无效，它并不保证对 volatile 变量的操作都是具有原子性的


     */

    private /*volatile*/ int ticket = 100;

    //private volatile AtomicInteger ticket = new AtomicInteger(100);//不起作用，保证原子性，但并不同步

    @Override
    public void run() {

        synchronized (SellingRunnable.class) {

            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ticket == 0) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " --> " + ticket);

                --ticket; //这是一个非原子操作，不能放在第一句
            }
        }

    }

}
