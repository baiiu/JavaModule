package com.example.InterpreterPattern.sample02;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:46
 * description:
 * And解释：非终结符表达式
 */
class AndNode extends AbstractNode {
    private AbstractNode left; //And的左表达式
    private AbstractNode right; //And的右表达式

    // 链表
    AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    //And表达式解释操作
    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}
