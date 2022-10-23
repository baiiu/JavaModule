package com.example.MementoPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 06:56
 * description:
 * 象棋棋子类：原发器
 */
class Chessman {
    private String label;
    private int x;
    private int y;

    Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    void setLabel(String label) {
        this.label = label;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    String getLabel() {
        return (this.label);
    }

    int getX() {
        return (this.x);
    }

    int getY() {
        return (this.y);
    }

    //保存状态
    ChessmanMemento save() {
        return new ChessmanMemento(this.label, this.x, this.y);
    }

    //恢复状态
    void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}
