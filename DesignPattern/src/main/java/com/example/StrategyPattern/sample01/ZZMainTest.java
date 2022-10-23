package com.example.StrategyPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/22 22 09:22
 * description:
 */
class ZZMainTest {

    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount = new VIPDiscount();
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }

}
