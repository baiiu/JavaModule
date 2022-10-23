package com.example.InterpreterPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:25
 * description:
 * 语句命令节点类：非终结符表达式
 */
class CommandNode extends Node {
    private Node node;

    @Override
    public void interpret(Context context) {
        if (context.currentToken().equals("LOOP")) {
            //处理LOOP循环命令
            node = new LoopCommandNode();
            node.interpret(context);
        } else {
            //处理其他基本命令
            node = new PrimitiveCommandNode();
            node.interpret(context);
        }
    }

    @Override
    public void execute() {
        node.execute();
    }
}