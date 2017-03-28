package com.example.studentSetAndGet;

/**
 * auther: baiiu
 * time: 17/3/28 28 07:41
 * description:
 */
class Student {
    String name;
    int age;
    boolean flag; //表示生产好了么


    @Override public String toString() {
        return name + " --- " + age;
    }
}
