package com.example.InterpreterPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:22
 * description: 抽象节点类：抽象表达式
 */
abstract class Node {
    //声明一个方法用于解释语句
    public abstract void interpret(Context text);

    //声明一个方法用于执行标记对应的命令
    public abstract void execute();
}
