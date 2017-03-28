package com.example.studentSetAndGet;

/**
 * auther: baiiu
 * time: 17/3/28 28 07:44
 * description:
 */
class GetRunnable implements Runnable {
    private final Student student;

    GetRunnable(Student student) {
        this.student = student;
    }

    @Override public void run() {
        while (true) {
            synchronized (student) {
                if (!student.flag) {
                    //没生产好，就等待
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                // 生产好了就消费
                System.out.println(student.toString());

                student.flag = false;//消费完了，让去生产
                student.notify();
            }
        }

    }

}
