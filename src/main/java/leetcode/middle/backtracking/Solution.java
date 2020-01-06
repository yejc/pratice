package leetcode.middle.backtracking;

import java.util.*;

/**
 * @author yejc
 * @date 2020/1/5 10:49
 */
public class Solution {

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

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        letterCombinationsHelper(digits, 0, "", result, map);
        return result;
    }

    private void letterCombinationsHelper(String digits, int index, String letter, List<String> result, Map<Character, List<Character>> map) {
        if (index == digits.length()) {
            result.add(letter);
            return;
        }
        List<Character> list = map.get(digits.charAt(index));
        for (Character character : list) {
            letterCombinationsHelper(digits, index + 1, letter + character, result, map);
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
        if (n < 1) {
            return result;
        }
        generateParenthesisHelper("", 0, 0, result, n);
        return result;
    }

    private void generateParenthesisHelper(String letter, int open, int close, List<String> result, int max) {
        if (letter.length() == max * 2) {
            result.add(letter);
        }
        if (open < max) {
            generateParenthesisHelper(letter + "(", open + 1, close, result, max);
        }
        if (close < open) {
            generateParenthesisHelper(letter + ")", open, close + 1, result, max);
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
        permuteHelper(nums, new ArrayList<>(), result, visited);
        return result;
    }

    private void permuteHelper(int[] nums, ArrayList<Integer> tmp, List<List<Integer>> result, boolean[] visited) {
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
            permuteHelper(nums, tmp, result, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
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
                if (existHelper(board, i, j, word, visited)) {
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
        boolean flag = false;
        // 向右走
        if (j < board[i].length - 1 && !visited[i][j + 1]) {
            flag = existHelper(board, i, j + 1, word.substring(1, word.length()), visited);
            if (flag) {
                visited[i][j] = false;
                return true;
            }
        }
        // 向下走
        if (i < board.length - 1 && !visited[i + 1][j]) {
            flag = existHelper(board, i + 1, j, word.substring(1, word.length()), visited);
            if (flag) {
                visited[i][j] = false;
                return true;
            }
        }
        // 向左走
        if (j > 0 && !visited[i][j - 1]) {
            flag = existHelper(board, i, j - 1, word.substring(1, word.length()), visited);
            if (flag) {
                visited[i][j] = false;
                return true;
            }
        }

        // 向上走
        if (i > 0 && !visited[i - 1][j]) {
            flag = existHelper(board, i - 1, j, word.substring(1, word.length()), visited);
            if (flag) {
                visited[i][j] = false;
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }
}
