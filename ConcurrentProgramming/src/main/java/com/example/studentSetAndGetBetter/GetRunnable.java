package com.example.studentSetAndGetBetter;

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
            Student student = this.student.get();
            if (student != null) {
                System.out.println(student.toString());
            }
        }

    }

}
