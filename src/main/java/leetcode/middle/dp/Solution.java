package leetcode.middle.dp;

/**
 * @author yejc
 * @date 2020/1/26 21:43
 */
public class Solution {

    /**
     * 跳跃游戏
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length && dp[i]; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 不同路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 零钱兑换
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        cost = Integer.min(cost, dp[i - coins[j]] + 1);
                    }
                }
            }
            dp[i] = cost;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {2};
        int b = solution.coinChange(coins, 1);
        System.out.println(b);
    }


}
