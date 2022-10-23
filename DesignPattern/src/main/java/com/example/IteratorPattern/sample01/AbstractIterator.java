package com.example.IteratorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/19 19 07:27
 * description:
 */
interface AbstractIterator {
    Object next(); //移至下一个元素

    boolean isLast(); //判断是否为最后一个元素

    Object previous(); //移至上一个元素

    boolean isFirst(); //判断是否为第一个元素

    Object getNextItem(); //获取下一个元素

    Object getPreviousItem(); //获取上一个元素
}
