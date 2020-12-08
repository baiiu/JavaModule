package com.example.atomicTest;

/**
 * author: baiiu
 * time: 2020/12/8
 * description: 线程安全的，根据happens-before的volatile原则推理，是顺序一致性的
 */
public class TestAtomic {

    public static void main(String[] args) {
        final AtomicResource atomicResource = new AtomicResource();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            atomicResource.increment();
                        }
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("atomicResource#get: " + atomicResource.getNumber());
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("atomicResource#get: " + atomicResource.getNumber());

    }

}
