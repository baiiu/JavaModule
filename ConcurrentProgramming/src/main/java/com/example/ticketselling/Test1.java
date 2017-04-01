package com.example.ticketselling;

/**
 * author: baiiu
 * date: on 17/3/26 12:47
 * description: 多线程同步问题： 多个线程共用一把锁
 */
public class Test1 {

    public static void main(String[] args) {

        //看到效果
        new SellingThread(false).start();
        new SellingThread(true).start();


    }

}
