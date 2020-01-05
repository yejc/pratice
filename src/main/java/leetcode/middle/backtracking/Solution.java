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
}
