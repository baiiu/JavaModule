package com.example.callableTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * auther: baiiu
 * time: 17/3/30 30 07:10
 * description:
 */

public class TestCallable {

    static class TCallable implements Callable<Integer> {
        private int number;

        public TCallable(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;

            for (int i = 0; i < number; i++) {
                sum += i;
            }

            return sum;
        }
    }

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();

        final ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = threadPool.submit(new TCallable(10));
        Future<Integer> f2 = threadPool.submit(new TCallable(20));

        Future<Integer> f3 = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return 10;
            }
        });


        try {
            System.out.println(f1.get());
            System.out.println(f2.get());

//            Thread.sleep(1002);
//            if(System.currentTimeMillis() - start > 1000){
//                threadPool.shutdownNow();
//            }

            System.out.println(f3.get());//一直等到任务结束后再打印
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();


    }


}
