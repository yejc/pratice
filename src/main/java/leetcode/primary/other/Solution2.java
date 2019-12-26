package leetcode.primary.other;

import java.util.*;

/**
 * @author yejc
 * @date 2019/12/24 20:32
 */
public class Solution2 {

    /**
     * 位1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 汉明距离
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        int n = x ^ y;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    /**
     * 颠倒二进制位
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
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
}