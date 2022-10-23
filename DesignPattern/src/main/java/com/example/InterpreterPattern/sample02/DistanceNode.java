package com.example.InterpreterPattern.sample02;

/**
 * auther: baiiu
 * time: 18/12/18 18 06:50
 * description: 距离解释：终结符表达式
 */
class DistanceNode extends AbstractNode {
    private String distance;

    DistanceNode(String distance) {
        this.distance = distance;
    }

    //距离表达式的解释操作
    @Override
    public String interpret() {
        return this.distance;
    }
}