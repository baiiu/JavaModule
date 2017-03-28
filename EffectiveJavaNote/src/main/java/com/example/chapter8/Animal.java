package com.example.chapter8;

/**
 * auther: baiiu
 * time: 17/3/19 19 11:27
 * description:
 */

public class Animal {
    public String name;
    public boolean sex;

    public Animal(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", sex=" + sex + '}';
    }
}
