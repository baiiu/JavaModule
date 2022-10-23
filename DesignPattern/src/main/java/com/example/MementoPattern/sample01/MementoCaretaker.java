package com.example.MementoPattern.sample01;

import java.util.ArrayList;

/**
 * auther: baiiu
 * time: 18/12/20 20 06:59
 * description:
 * 象棋棋子备忘录管理类：负责人
 */
class MementoCaretaker {
    //定义一个集合来存储多个备忘录，可以是栈等
    private ArrayList<ChessmanMemento> mMementoList = new ArrayList<>();

    private int currentIndex = -1;

    // 保存一步
    void save(ChessmanMemento memento) {
        mMementoList.add(memento);
        ++currentIndex;
    }

    // 撤销到上一步
    ChessmanMemento undo() {
        --currentIndex;
        return mMementoList.get(currentIndex);
    }

    ChessmanMemento redo() {
        ++currentIndex;
        return mMementoList.get(currentIndex);
    }

}
