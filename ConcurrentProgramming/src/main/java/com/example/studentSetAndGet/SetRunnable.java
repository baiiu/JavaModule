package com.example.studentSetAndGet;

/**
 * auther: baiiu
 * time: 17/3/28 28 07:44
 * description:
 */
class SetRunnable implements Runnable {
    private final Student student;
    private int i;

    SetRunnable(Student student) {
        this.student = student;
    }

    @Override public void run() {
        while (true) {
            synchronized (student) {

                //如果生产好了，就等待消费
                if (student.flag) {
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i % 2 == 0) {
                    student.name = "Li";
                    student.age = 25;
                } else {
                    student.name = "Zhang";
                    student.age = 30;
                }

                ++i;

                student.flag = true; //表示生产好了，等待消费
                student.notify();//唤醒该锁上的对象，来消费
            }
        }
    }

}
