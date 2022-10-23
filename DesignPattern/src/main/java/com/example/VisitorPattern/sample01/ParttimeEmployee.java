package com.example.VisitorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:41
 * description: 兼职员工类：具体元素类
 */
class ParttimeEmployee implements Employee {
    private String name;
    private double hourWage;
    private int workTime;

    ParttimeEmployee(String name, double hourWage, int workTime) {
        this.name = name;
        this.hourWage = hourWage;
        this.workTime = workTime;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return (this.name);
    }

    double getHourWage() {
        return (this.hourWage);
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
