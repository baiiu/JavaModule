package com.example.studentSetAndGet;

/**
 * auther: baiiu
 * time: 17/3/28 28 07:41
 * description:
 */
public class TestStudent {

    public static void main(String[] args) {

        Student student = new Student();

        Thread setThread = new Thread(new SetRunnable(student));
        Thread getThread = new Thread(new GetRunnable(student));

        setThread.start();
        getThread.start();

    }

}
