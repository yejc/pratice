package offer;

/**
 * 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子减成 m 段（m、n都是整数，n > 1 并且 m >1）,每段绳子的长度记为k[0], k[1],...,k[m]。请问k[0]*k[1]*k[2]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成的长度为2、3、3三段，此时得到的最大乘积是18。
 *
 * @author yejc
 * @date 2020/3/9 21:42
 */
public class CutString {
    public int run(int len) {
        if (len == 1 || len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }
        int[] dp = new int[len + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= len; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        CutString cutString = new CutString();
        int i = cutString.run(8);
        System.out.println(i);
    }
}
