package com.example.VisitorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:37
 * description: 员工类：抽象元素类
 */
interface Employee {
    void accept(Department handler); //接受一个抽象访问者访问
}

