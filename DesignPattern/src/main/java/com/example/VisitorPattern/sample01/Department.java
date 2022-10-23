package com.example.VisitorPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 22:40
 * description: 部门类：抽象访问者类
 */
abstract class Department {
    //声明一组重载的访问方法，用于访问不同类型的具体元素
    abstract void visit(FulltimeEmployee employee);

    abstract void visit(ParttimeEmployee employee);
}