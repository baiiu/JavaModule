package com.example.atomicTest;

/**
 * author: baiiu
 * time: 2020/12/8
 * description: 线程安全的，根据happens-before的volatile原则推理，是顺序一致性的
 */
public class TestAtomic {

    public static void main(String[] args) {
        final AtomicResource atomicResource = new AtomicResource();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    for (int j = 0; j < 100; j++) {
                        atomicResource.increment();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("atomicResource#get: " + atomicResource.getNumber());

                    try {
                        Thread.sleep(210);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("atomicResource#get: " + atomicResource.getNumber());

    }

}
