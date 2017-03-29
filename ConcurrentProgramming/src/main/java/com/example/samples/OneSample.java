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
        PrintCount r = new PrintCount();

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }

}
