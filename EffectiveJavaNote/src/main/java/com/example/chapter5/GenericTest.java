package com.example.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * auther: baiiu
 * time: 17/3/15 15 06:59
 * description: 泛型
 */
public class GenericTest {

    public static void main(String[] args) {
        code23();
        code25();




    }

    private static void code25() {
        Object[] objects = new Long[1]; //正确，不抛错
        objects[0] = "1";//运行时抛出异常，java.lang.ArrayStoreException: java.lang.String

        //List<Object> list = new ArrayList<Long>();//编译时抛出异常，不兼容的类型，无法转换
        //list.add("1"); //可以添加


        //List<String>[] S = new List<String>[1];//Generic array creation
        List<?>[] S = new List<?>[1];//Generic array creation
    }

    private static void code23() {
        /*
            1. List<String>是原生态类型List的一个子类型，而不是参数化类型List<Object>的子类型。
         */
        List<Object> list = new ArrayList<>();
        List<String> l = new ArrayList<>();
        //list = l; // 编译时报错

        /*
            在参数化类型而非无限制通配符类型上使用instanceof操作符是非法的。

         */
        //boolean b = list instanceof List<String>; //编译时报错
        boolean b = list instanceof List<?>;
    }


    /*
        原生态类型是不安全的，可以将任何元素放进去，很容易破坏集合的类型约束条件；
        而通配符类型是安全的，如下代码，它防止你破坏集合的类型约束条件，将无法将任何元素add进去。
     */
    private static void add(List<?> list, Object o) {
        // list.add(o); //运行时会抛出java.lang.Error: Unresolved compilation problem:。
    }
}
