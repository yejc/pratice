package recursion;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 骑士周游（回溯算法优化为贪心算法）
 * 一个X*Y的棋盘，棋子只能走“日”字，如何走才能经过棋盘的每一个位置
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-11-26 20:24
 **/
public class HorseChessBoard {
    /**
     * X*Y的棋盘
     */
    private int X;
    private int Y;

    /**
     * 棋盘
     */
    int[][] chessboard;
    private boolean[] visited;
    /**
     * 是否完成
     */
    private boolean finished;

    public static void main(String[] args) {
        int row = 8;
        int column = 8;
        HorseChessBoard horseChessBoard = new HorseChessBoard(row, column);
        horseChessBoard.travel(0, 0, 1);
        horseChessBoard.print();
    }

    public HorseChessBoard(int x, int y) {
        this.X = x;
        this.Y = y;
        chessboard = new int[X][Y];
        visited = new boolean[X * Y];
    }

    /**
     * 通过回溯找到满足题解的解法
     *
     * @param row    行
     * @param column 列
     * @param step   步数
     */
    private void travel(int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        List<Point> next = next(new Point(row, column));
        // 贪心算法优化，按非递减排序，使得回溯次数减少
        next.sort((o1, o2) -> {
            return next(o1).size() - next(o2).size();
        });
        for (Point point : next) {
            if (!visited[point.x * X + point.y]) {
                travel(point.x, point.y, step + 1);
            }
        }
        if (step < X * Y && !finished) {
            // 这种情况处于尚未找到解，且在回溯过程中
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            // 找到解
            finished = true;
        }

    }

    public void print() {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                System.out.print(chessboard[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 获取当前位置下一步可以走的位置集合
     *
     * @param point
     * @return
     */
    private List<Point> next(Point point) {
        List<Point> result = new ArrayList<>();
        Point p = new Point();
        if ((p.x = point.x - 2) >= 0 && (p.y = point.y - 1) >= 0) {
            result.add(new Point(p));
        }
        if ((p.x = point.x - 1) >= 0 && (p.y = point.y - 2) >= 0) {
            result.add(new Point(p));
        }
        if ((p.x = point.x + 1) < X && (p.y = point.y - 2) >= 0) {
            result.add(new Point(p));
        }
        if ((p.x = point.x + 2) < X && (p.y = point.y - 1) >= 0) {
            result.add(new Point(p));
        }
        if ((p.x = point.x - 2) >= 0 && (p.y = point.y + 1) < Y) {
            result.add(new Point(p));
        }
        if ((p.x = point.x - 1) >= 0 && (p.y = point.y + 2) < Y) {
            result.add(new Point(p));
        }
        if ((p.x = point.x + 1) < X && (p.y = point.y + 2) < Y) {
            result.add(new Point(p));
        }
        if ((p.x = point.x + 2) < X && (p.y = point.y + 1) < Y) {
            result.add(new Point(p));
        }
        return result;
    }
}
