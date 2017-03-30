package com.example.buffer;

/**
 * author: baiiu
 * date: on 17/3/29 17:29
 * description:
 */
class ButterTest {

    public static void main(String[] args) {
        final Buffer buffer = new Buffer();
//        final BoundedBuffer buffer = new BoundedBuffer();

        Runnable takeRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " 取出---> " + buffer.take());
                }
            }
        };

        Runnable putRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; ++i) {
                    System.out.println(Thread.currentThread().getName() + " --> 存入" + i);
                    buffer.put("" + i);
                }
            }
        };

        new Thread(putRunnable).start();
        new Thread(takeRunnable).start();

    }

}
