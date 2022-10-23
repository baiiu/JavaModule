package com.example.VisitorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:40
 * description: 全职员工类：具体元素类
 */
class FulltimeEmployee implements Employee {
    private String name;
    private double weeklyWage;
    private int workTime;

    FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    void setName(String name) {
        this.name = name;
    }

    void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    String getName() {
        return (this.name);
    }

    double getWeeklyWage() {
        return (this.weeklyWage);
    }

    int getWorkTime() {
        return (this.workTime);
    }

    @Override
    public void accept(Department handler) {
        //调用访问者的访问方法
        handler.visit(this);
    }
}
