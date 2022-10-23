package com.example.IteratorPattern.sample01;

import java.util.ArrayList;
import java.util.List;

/**
 * auther: baiiu
 * time: 18/12/19 19 07:27
 * description:
 */
abstract class AbstractObjectList {
    private List<Object> objects = new ArrayList<Object>();

    AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    List<Object> getList() {
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();
}
