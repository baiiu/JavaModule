package com.example.studentSetAndGetBetter;

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
            if (i % 2 == 0) {
                student.set("Li", 25);
            } else {
                student.set("Zhang", 30);
            }

            ++i;
        }
    }

}
