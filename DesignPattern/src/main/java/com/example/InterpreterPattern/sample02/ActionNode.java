package com.example.InterpreterPattern.sample02;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:49
 * description:
 * 动作解释：终结符表达式
 */
class ActionNode extends AbstractNode {
    private String action;

    ActionNode(String action) {
        this.action = action;
    }

    //动作（移动方式）表达式的解释操作
    @Override
    public String interpret() {
        if (action.equalsIgnoreCase("move")) {
            return "移动";
        } else if (action.equalsIgnoreCase("run")) {
            return "快速移动";
        } else {
            return "无效指令";
        }
    }
}
