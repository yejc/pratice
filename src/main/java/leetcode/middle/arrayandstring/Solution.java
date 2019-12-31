package leetcode.middle.arrayandstring;

import java.util.*;

/**
 * @author yejc
 * @date 2019/12/25 19:54
 */
public class Solution {

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return result;
    }

    /**
     * 帕斯卡三角形
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    /**
     * 矩阵置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
        }

        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }

    /**
     * 字谜分组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 先按字符排序，再分组
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
//            String value = new String(chars);
            if (!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }
            map.get(value).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Integer.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            max = Integer.max(max, i - left + 1);
        }
        return max;
    }

    /**
     * 最长回文子串(dp)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String result = "";
        int maxLength = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end >= s.length()) { // 已越界
                    break;
                }
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (dp[start][end] && len > maxLength) {
                    result = s.substring(start, end + 1);
                    maxLength = len;
                }
            }
        }
        return result;
    }

    /**
     * 最长回文子串(扩展中心)
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int i, int j) {
        int L = i, R = j;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 递增的三元子序列
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            boolean left = false;
            boolean right = false;
            for (int L = i - 1; L >= 0; L--) {
                if (nums[L] < nums[i]) {
                    left = true;
                    break;
                }
            }
            for (int R = i + 1; R < nums.length; R++) {
                if (nums[R] > nums[i]) {
                    right = true;
                    break;
                }
            }
            if (left && right) {
                return true;
            }
        }
        return false;
    }
}
