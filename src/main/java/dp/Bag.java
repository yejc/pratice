package dp;

/**
 * @program: pratice
 * @description: 01背包问题：有3个物品，重量分别为1,2,4，价值分别为1500,2000,3000，背包最多能装5个单位的物品，如何往背包里放物品，使得背包里的物品价值最大，背包里的物品不能重复。
 * @author: yejc
 * @create: 2019-11-23 22:06
 **/
public class Bag {
    public static void main(String[] args) {
        // 物品重量
        int[] w = {1, 2, 4};
        // 物品价值
        int[] value = {1500, 2000, 3000};
        // 背包大小
        int m = 5;

        // 状态方程，v[i][j]表示第i+1个物品在背包最大承重为j的情况下，可选择的最大价值
        int[][] v = new int[w.length + 1][];
        // 存放背包轨迹
        int[][] trace = new int[w.length + 1][];
        for (int k = 0; k < v.length; k++) {
            v[k] = new int[m + 1];
            trace[k] = new int[m + 1];
        }
        v[0][0] = 0;

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (w[i - 1] > j) {
                    // 当前物品重量大于背包最大承重
                    v[i][j] = v[i - 1][j];
                } else {
                    // 当前物品重量小于背包最大承重
                    if (v[i - 1][j] > value[i - 1] + v[i - 1][j - w[i - 1]]) {
                        // 如果不放当前物品比放当前物品价值高，则v[i][j] = v[i -1][j]，意思是不放入当前物品，上一次怎么放，这一次就怎么放
                        v[i][j] = v[i - 1][j];
                    } else {
                        // 如果放入当前物品比不放当前物品价值高，则放入当前物品
                        v[i][j] = value[i - 1] + v[i - 1][j - w[i - 1]];
                        trace[i][j] = 1;
                    }
                }
            }
        }
        System.out.println("状态方程为：");
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.printf("背包可装最大价值为%d", v[w.length][m]);

        System.out.println();
        System.out.println("为了得到最大价值，可进行如下操作：");
        int i = trace.length - 1;
        int j = trace[0].length - 1;
        while (i > 0 && j > 0) {
            if (trace[i][j] == 1) {
                System.out.printf("将第%s个物品放入背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
