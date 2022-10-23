package com.example.AdapterPattern.sample01;

/**
 * author: baiiu
 * date: on 16/7/20 17:39
 * description:
 * <p>
 * 目标类提供了specificRequest()方法,但是现在系统提供的是request()方法.
 * 使用适配器模式进行转发
 */
class ZZMainClass {

    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }

}
