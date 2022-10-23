package com.example.MementoPattern.sample01;

/**
 * auther: baiiu
 * time: 18/12/20 20 07:10
 * description:
 */
class ZZMainTest {

    private static MementoCaretaker mc = new MementoCaretaker();

    // 针对该例子，这些操作使用门面模式可以封装在同一个类中，不用调方法
    public static void main(String args[]) {
        Chessman chess = new Chessman("车", 1, 1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess);
        undo(chess);
        redo(chess);
        redo(chess);
    }

    //下棋
    private static void play(Chessman chess) {
        mc.save(chess.save()); //保存备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    //悔棋
    private static void undo(Chessman chess) {
        System.out.println("******悔棋******");
        chess.restore(mc.undo()); //撤销到上一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    //撤销悔棋
    private static void redo(Chessman chess) {
        System.out.println("******撤销悔棋******");
        chess.restore(mc.redo()); //恢复到下一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }


}
