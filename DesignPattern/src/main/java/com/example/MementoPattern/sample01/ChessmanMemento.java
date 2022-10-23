package com.example.MementoPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 06:57
 * description:
 * 象棋棋子备忘录类
 */
class ChessmanMemento {
    private final String label;
    private final int x;
    private final int y;

    ChessmanMemento(String label, int x, int y) {
        this.label = label;
        this.x = x;
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
}
