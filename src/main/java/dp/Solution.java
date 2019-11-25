package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: pratice
 * @description:
 * @author: yejc
 * @create: 2019-11-24 17:40
 **/
public class Solution {
    /**
     * 爬楼梯（记忆化递归）
     *
     * @param n
     * @return
     */
    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            map.put(n, n);
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, result);
        return result;
    }

    /**
     * 爬楼梯（动态规划）
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 爬楼梯（斐波那契数列）
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;
    }
}
