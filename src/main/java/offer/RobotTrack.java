package offer;

/**
 * 机器人的运动范围
 * m*n方格，机器人从（0，0）出发，可以上下左右移动，但不能进入行坐标和纵坐标的数位之和大于k的格子,问能够到达多少个格子？
 *
 * @author yejc
 * @date 2020/3/9 19:53
 */
public class RobotTrack {
    public int walk(int rows, int cols, int k) {
        if (rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return walkHelper(rows, cols, 0, 0, k, visited);
    }

    private int walkHelper(int rows, int cols, int i, int j, int k, boolean[][] visited) {
        int count = 0;
        if (i >= 0 && j >= 0 && i < rows && j < cols && !visited[i][j] && getSum(i, j) <= k) {
            visited[i][j] = true;
            //向上走
            count = 1 + walkHelper(rows, cols, i - 1, j, k, visited)
                    //向下走
                    + walkHelper(rows, cols, i + 1, j, k, visited)
                    //向左走
                    + walkHelper(rows, cols, i, j - 1, k, visited)
                    //向右走
                    + walkHelper(rows, cols, i, j + 1, k, visited);
        }
        return count;
    }

    private int getSum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotTrack robotTrack = new RobotTrack();
        int walk = robotTrack.walk(30, 30, 30);
        System.out.println(walk);
    }
}
