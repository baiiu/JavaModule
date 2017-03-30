package com.example.samples;

/**
 * auther: baiiu
 * time: 17/3/29 29 07:41
 * description:
 * 线程1 打印1、2、3
 * 线程2 打印4、5、6
 * 线程1 打印7、8、9
 */
public class OneSample {

    public static void main(String[] args) {
//        final PrintCount r = new PrintCount();
        final PrintCountMore r = new PrintCountMore();

        new Thread() {
            @Override
            public void run() {
                r.print123();
//                r.print789();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                r.print123();
//                r.print789();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                r.print456();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                r.print456();
            }
        }.start();


    }

}
