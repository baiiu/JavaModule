package com.example.VisitorPattern.sample01;

import java.util.ArrayList;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:39
 * description:
 */
class ZZMEmployTest {
    private ArrayList<Employee> list = new ArrayList<Employee>(); //员工集合

    //增加员工
    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    //处理员工数据
    public void handle(String departmentName) {
        if (departmentName.equalsIgnoreCase("财务部")) //财务部处理员工数据
        {
            for (Object obj : list) {
                if (obj.getClass().getName().equalsIgnoreCase("FulltimeEmployee")) {
                    System.out.println("财务部处理全职员工数据！");
                } else {
                    System.out.println("财务部处理兼职员工数据！");
                }
            }
        } else if (departmentName.equalsIgnoreCase("人力资源部")) //人力资源部处理员工数据
        {
            for (Object obj : list) {
                if (obj.getClass().getName().equalsIgnoreCase("FulltimeEmployee")) {
                    System.out.println("人力资源部处理全职员工数据！");
                } else {
                    System.out.println("人力资源部处理兼职员工数据！");
                }
            }
        }
    }
}