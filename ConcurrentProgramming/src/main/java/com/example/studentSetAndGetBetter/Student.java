package com.example.studentSetAndGetBetter;

/**
 * auther: baiiu
 * time: 17/3/28 28 07:41
 * description:
 */
class Student {
    private String name;
    private int age;
    private boolean flag; //表示生产好了么

    synchronized void set(String name, int age) {
        if (flag) {
            //生产好了，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name;
        this.age = age;

        this.flag = true;//生产好了，去消费吧
        this.notify();
    }

    synchronized Student get() {
        if (flag) {
            //生产好了，消费
            this.flag = false;//消费完了，去生产吧
            this.notify();

            return this;
        }

        return null;
    }


    @Override public String toString() {
        return name + " --- " + age;
    }

}
