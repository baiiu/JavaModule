package com.example.InterpreterPattern.sample01;

import java.util.StringTokenizer;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:21
 * description:
 * 环境类：用于存储和操作需要解释的语句，
 * 在本实例中每一个需要解释的单词可以称为一个动作标记(Action Token)或命令
 */
class Context {
    private StringTokenizer tokenizer; //StringTokenizer类，用于将字符串分解为更小的字符串标记(Token)，默认情况下以空格作为分隔符
    private String currentToken; //当前字符串标记

    Context(String text) {
        tokenizer = new StringTokenizer(text); //通过传入的指令字符串创建StringTokenizer对象
        nextToken();
    }

    //返回下一个标记
    void nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
    }

    //返回当前的标记
    String currentToken() {
        return currentToken;
    }

    //跳过一个标记
    void skipToken(String token) {
        if (!token.equals(currentToken)) {
            System.err.println("错误提示：" + currentToken + "解释错误！");
        }
        nextToken();
    }

    //如果当前的标记是一个数字，则返回对应的数值
    int currentNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken); //将字符串转换为整数
        } catch (NumberFormatException e) {
            System.err.println("错误提示：" + e);
        }
        return number;
    }
}
