package com.example.InterpreterPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:26
 * description:
 * 循环命令节点类：非终结符表达式
 */
class LoopCommandNode extends Node {
    private int number; //循环次数
    private Node commandNode; //循环语句中的表达式

    //解释循环命令
    @Override
    public void interpret(Context context) {
        context.skipToken("LOOP");
        number = context.currentNumber();
        context.nextToken();
        commandNode = new ExpressionNode(); //循环语句中的表达式
        commandNode.interpret(context);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandNode.execute();
        }
    }
}