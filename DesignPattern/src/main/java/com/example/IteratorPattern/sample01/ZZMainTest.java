package com.example.IteratorPattern.sample01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * auther: baiiu
 * time: 18/12/19 19 07:30
 * description:
 */
class ZZMainTest {
    public static void main(String[] args) {
        List<Object> products = new ArrayList<>();
        products.add("倚天剑");
        products.add("屠龙刀");
        products.add("断肠草");
        products.add("葵花宝典");
        products.add("四十二章经");

        AbstractObjectList list;
        AbstractIterator iterator;

        list = new ProductList(products); //创建聚合对象
        iterator = list.createIterator();    //创建迭代器对象

        System.out.println("正向遍历：");
        while (!iterator.isLast()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");
        while (!iterator.isFirst()) {
            System.out.println(iterator.previous());
        }

        List<String> testList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testList.add("value: " + String.valueOf(i));
        }
        Iterator<String> testIterator = testList.iterator();

//        testIterator.next();
//        testIterator.remove();
//        testIterator.next();

        while (testIterator.hasNext()) {
            String next = testIterator.next();

            if (next.equals("value: 2")) {
                testIterator.remove();
                continue;
            }
            System.out.println(next);

//            testIterator.next();
//            testIterator.remove();
        }
    }
}
