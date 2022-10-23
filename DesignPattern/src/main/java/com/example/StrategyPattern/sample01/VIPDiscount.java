package com.example.StrategyPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 09:22
 * description:
 */

class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
