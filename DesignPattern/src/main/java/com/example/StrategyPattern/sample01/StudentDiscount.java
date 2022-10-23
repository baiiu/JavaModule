package com.example.StrategyPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 09:21
 * description:
 */
class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}

