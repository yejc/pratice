package recursion;

/**
 * 采用回溯法判断迷宫能否从起点到达终点
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-11-25 21:10
 **/
public class MazePath {
    /**
     * 5*5的迷宫
     */
    private int[][] map = new int[5][5];

    /**
     * 初始化迷宫
     * map[i][j] = 0 表示位置(i,j)没走过，也没有墙；
     * map[i][j] = 1 表示位置(i,j)有墙，无法行走；
     * map[i][j] = 2 表示位置(i,j)已走过并且可能为到达迷宫的所经过的位置；
     * map[i][j] = 3 表示位置(i,j)已走过，但是无法经过此位置到达终点；
     */
    public void init() {
//        1 1 1 1 1
//        1 0 0 0 1
//        1 1 1 0 1
//        1 0 0 0 1
//        1 1 1 1 1
        // 初始化为以上形状的迷宫，四周围墙，位置(2,1)和(2,2)有墙
        // (1,1)为起点，(3,3)为终点
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 4 || j == 0 || j == 4) {
                    map[i][j] = 1;
                }
            }
        }
        map[2][1] = 1;
        map[2][2] = 1;
    }

    /**
     * 按照下->右->上->左的策略回溯
     *
     * @param i
     * @param j
     * @return
     */
    public boolean walk(int i, int j) {
        if (map[3][3] == 2) {
            System.out.println("成功走出迷宫，路径如下：");
            print(map);
            return true;
        }
        if (map[i][j] == 0) {
            // 如果没有墙，并且没有走过
            map[i][j] = 2;
            if (walk(i + 1, j)) {
                return true;
            }
            if (walk(i, j + 1)) {
                return true;
            }
            if (walk(i - 1, j)) {
                return true;
            }
            if (walk(i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    private void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazePath mazePath = new MazePath();
        mazePath.init();
        System.out.println("能否走出迷宫？" + mazePath.walk(1, 1));
    }
}
