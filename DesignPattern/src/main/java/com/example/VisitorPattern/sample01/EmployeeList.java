package com.example.VisitorPattern.sample01;

import java.util.ArrayList;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:43
 * description: 员工列表类：对象结构
 */
class EmployeeList {
    //定义一个集合用于存储员工对象
    private ArrayList<Employee> list = new ArrayList<Employee>();

    void addEmployee(Employee employee) {
        list.add(employee);
    }

    //遍历访问员工集合中的每一个员工对象
    void accept(Department handler) {
        for (Object obj : list) {
            ((Employee) obj).accept(handler);
        }
    }
}