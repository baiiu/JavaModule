package com.example.InterpreterPattern.sample02;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:40
 * description:
 */
class ZZMainClass {
    /*
        down run 10 and left move 20

expression ::= direction action distance | composite //表达式
composite ::= expression 'and' expression //复合表达式
direction ::= 'up' | 'down' | 'left' | 'right' //移动方向
action ::= 'move' | 'run' //移动方式
distance ::= an integer //移动距离
     */
    public static void main(String[] args) {
        String instruction = "up move 5 and down run 10 and left move 5";

        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString = handler.output();
        System.out.println(outString);
    }
}
