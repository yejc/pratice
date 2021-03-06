package leetcode.middle.backtracking;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/16 21:43
 */
public class Solution2 {
    /**
     * 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        letterCombinationsHelper(digits, 0, "", result, map);
        return result;
    }

    private void letterCombinationsHelper(String digits, int i, String str, List<String> result, Map<Character, List<String>> map) {
        if (i == digits.length()) {
            result.add(str);
            return;
        }
        char c = digits.charAt(i);
        List<String> list = map.get(c);
        for (String s : list) {
            letterCombinationsHelper(digits, i + 1, str + s, result, map);
        }
    }

    /**
     * 生成括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, "", result);
        return result;
    }

    private void generateParenthesisHelper(int n, int k, String str, List<String> result) {
        if (n < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            result.add(str);
            return;
        }
        generateParenthesisHelper(n - 1, k + 1, str + "(", result);
        if (k > 0) {
            generateParenthesisHelper(n, k - 1, str + ")", result);
        }
    }

    /**
     * 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, 0, new ArrayList<>(), result, visited);
        return result;
    }

    private void permuteHelper(int[] nums, int index, List<Integer> tmp, List<List<Integer>> result, boolean[] visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            permuteHelper(nums, index + 1, tmp, result, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * 子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void subsetsHelper(int[] nums, int i, List<List<Integer>> result, ArrayList<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            subsetsHelper(nums, j + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * 单词搜索
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = existHelper(board, i, j, word, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, int i, int j, String word, boolean[][] visited) {
        if (board[i][j] != word.charAt(0)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        visited[i][j] = true;
        // 向右走
        if (j < board[i].length - 1 && !visited[i][j + 1]) {
            boolean flag = existHelper(board, i, j + 1, word.substring(1), visited);
            if (flag) {
                return true;
            }
        }
        // 向下走
        if (i < board.length - 1 && !visited[i + 1][j]) {
            boolean flag = existHelper(board, i + 1, j, word.substring(1), visited);
            if (flag) {
                return true;
            }
        }
        // 向左走
        if (j > 0 && !visited[i][j - 1]) {
            boolean flag = existHelper(board, i, j - 1, word.substring(1), visited);
            if (flag) {
                return true;
            }
        }
        // 向上走
        if (i > 0 && !visited[i - 1][j]) {
            boolean flag = existHelper(board, i - 1, j, word.substring(1), visited);
            if (flag) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
