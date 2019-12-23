package extra.recursion;

/**
 * 求出八皇后所有解
 *
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-11-25 20:16
 **/
public class Quene8 {

    private final int M = 8;
    private int[] result = new int[8];
    /**
     * 解法总数
     */
    int count = 0;


    /**
     * 用数组int[] result 表示8皇后的一种解法，数组下标i表示第i+1行，第i+1行的皇后放在第result[i]+1列
     * {2,4,3,6,1,5,7,0}表示第一行皇后放在第三列，第二行放在第五列，第三行放在第四列，以此推类
     *
     * @param n
     */
    public void check(int n) {
        if (n == M) {
            // 找到一种八皇后解法
            // 打印解法
            count++;
            print(result);
        }
        // 每列逐一尝试
        for (int j = 0; j < M; j++) {
            if (judge(n, j)) {
                result[n] = j;
                check(n + 1);
            }
        }
    }

    /**
     * 判断当前行是否与之前行的皇后互相攻击
     *
     * @param n 当前判断的行
     * @param j 当前行的皇后所在列
     * @return
     */
    private boolean judge(int n, int j) {
        for (int i = 0; i < n; i++) {
            if (result[i] == j || Math.abs(i - n) == Math.abs(result[i] - j)) {
                return false;
            }
        }
        return true;
    }

    private void print(int[] result) {
        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Quene8 quene8 = new Quene8();
        quene8.check(0);
        System.out.printf("总共解法数：%d", quene8.count);
    }
}
