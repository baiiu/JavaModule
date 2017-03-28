package com.example.chapter8;

/**
 * auther: baiiu
 * time: 17/3/19 19 12:40
 * description:
 */

public class TestAutoBoxing {

    public static void main(String[] args) {
        System.out.println(new Integer(42) == new Integer(42));
        Object o = new Object();
        System.out.println(o.toString());
    }

}
