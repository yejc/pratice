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

    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution solution = new Solution();
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }
}
