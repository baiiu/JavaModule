package com.example.consumerAndProducer;

/**
 * author: baiiu
 * date: on 17/3/28 10:37
 * description:
 */
class Resource {

    private int count;
    boolean flag; //表示生产好了么

    Resource(int count) {
        this.count = count;
    }

    int produce() {
        return ++count;
    }

    int consume() {
        return --count;
    }


}
